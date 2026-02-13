import { useEffect, useState } from "react";
import { polizasApi } from "../../services/polizas";
import { clientesApi } from "../../services/clientes";
import { planesApi } from "../../services/planes";

export default function PolizasCRUD() {
  const [polizas, setPolizas] = useState([]);
  const [planes, setPlanes] = useState([]);
  const [mensaje, setMensaje] = useState("");

  const [form, setForm] = useState({
    nombres: "",
    identificacion: "",
    email: "",
    telefono: "",
    planId: ""
  });

  const cargar = () => {
    polizasApi.getAll().then(r => setPolizas(r.data));
  };

  const cargarPlanes = () => {
    planesApi.getAll().then(r => setPlanes(r.data));
  };

  useEffect(() => {
    cargar();
    cargarPlanes();
  }, []);

  //  FLUJO CORRECTO
  const emitir = async () => {
    if (
      !form.nombres ||
      !form.identificacion ||
      !form.email ||
      !form.telefono ||
      !form.planId
    ) {
      setMensaje(" Completa todos los campos");
      return;
    }

    try {
      //  Crear cliente
      const clienteResp = await clientesApi.create({
        nombres: form.nombres,
        identificacion: form.identificacion,
        email: form.email,
        telefono: form.telefono
      });

      const clienteId = clienteResp.data.id;

      //  Emitir póliza
      await polizasApi.emitir({
        clienteId: clienteId,
        planId: Number(form.planId)   // 👈 importante: number
      });

      setMensaje("Cliente creado y póliza emitida correctamente");

      setForm({
        nombres: "",
        identificacion: "",
        email: "",
        telefono: "",
        planId: ""
      });

      cargar();

    } catch (error) {
      console.error(error);
      setMensaje("Error al emitir póliza (verifica backend y DTO)");
    }
  };

  const cancelar = async (id) => {
    if (!confirm("¿Seguro que deseas cancelar esta póliza?")) return;

    try {
      await polizasApi.cancelar(id);
      setMensaje(" Póliza cancelada correctamente");
      cargar();
    } catch (e) {
      setMensaje(" Error al cancelar póliza");
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Pólizas</h2>

      {mensaje && <div style={{ marginBottom: "10px" }}>{mensaje}</div>}

      <h3>Crear cliente y emitir póliza</h3>

      <div style={{ display: "flex", flexDirection: "column", maxWidth: "420px", gap: "8px" }}>
        <input placeholder="Nombres" value={form.nombres}
          onChange={e => setForm({ ...form, nombres: e.target.value })} />

        <input placeholder="Identificación" value={form.identificacion}
          onChange={e => setForm({ ...form, identificacion: e.target.value })} />

        <input placeholder="Email" value={form.email}
          onChange={e => setForm({ ...form, email: e.target.value })} />

        <input placeholder="Teléfono" value={form.telefono}
          onChange={e => setForm({ ...form, telefono: e.target.value })} />

        <select value={form.planId}
          onChange={e => setForm({ ...form, planId: e.target.value })}>
          <option value="">-- Seleccionar plan --</option>
          {planes.map(p => (
            <option key={p.id} value={p.id}>
              {p.nombre} | {p.tipo} | ${p.primaBase}
            </option>
          ))}
        </select>

        <button onClick={emitir}>Crear cliente y emitir póliza</button>
      </div>

      <h3 style={{ marginTop: "25px" }}>Listado de pólizas</h3>

      <table border="1" cellPadding="6">
        <thead>
          <tr>
            <th>ID</th>
            <th>Número</th>
            <th>Cliente</th>
            <th>Plan</th>
            <th>Estado</th>
            <th>Acción</th>
          </tr>
        </thead>

        <tbody>
          {polizas.map(p => (
            <tr key={p.id}>
              <td>{p.id}</td>
              <td>{p.numeroPoliza}</td>
              <td>{p.cliente?.nombres}</td>
              <td>{p.plan?.nombre}</td>
              <td>{p.estado}</td>
              <td>
                {p.estado === "ACTIVA"
                  ? <button onClick={() => cancelar(p.id)}>Cancelar</button>
                  : <span>Cancelada</span>
                }
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}