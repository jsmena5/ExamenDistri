import { useEffect, useState } from "react";
import { planesApi } from "../../services/planes";

export default function PlanesCRUD() {
  const [planes, setPlanes] = useState([]);
  const [form, setForm] = useState({
    nombre: "",
    tipo: "",
    primaBase: "",
    coberturaMax: ""
  });

  const [mensaje, setMensaje] = useState("");
  const [editId, setEditId] = useState(null);

  const cargar = () => {
    planesApi.getAll().then(r => setPlanes(r.data));
  };

  useEffect(() => {
    cargar();
  }, []);

  const guardar = async () => {
    if (!form.nombre || !form.tipo || !form.primaBase || !form.coberturaMax) {
      return setMensaje("Todos los campos son obligatorios");
    }

    try {
      if (editId) {
        await planesApi.update(editId, form);
        setMensaje(" Plan actualizado correctamente");
      } else {
        await planesApi.create(form);
        setMensaje(" Plan creado correctamente");
      }

      setForm({ nombre: "", tipo: "", primaBase: "", coberturaMax: "" });
      setEditId(null);
      cargar();
    } catch (e) {
      setMensaje(" Error al guardar el plan");
    }
  };

  const editar = (plan) => {
    setForm({
      nombre: plan.nombre,
      tipo: plan.tipo,
      primaBase: plan.primaBase,
      coberturaMax: plan.coberturaMax
    });
    setEditId(plan.id);
  };

  const eliminar = async (id) => {
    if (!confirm("¿Seguro que deseas eliminar este plan?")) return;

    try {
      await planesApi.delete(id);
      setMensaje(" Plan eliminado correctamente");
      cargar();
    } catch (e) {
      setMensaje(" Error al eliminar el plan");
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Planes de Seguro</h2>

      {mensaje && <div style={{ marginBottom: "10px" }}>{mensaje}</div>}

      <div style={{ marginBottom: "15px" }}>
        <input
          placeholder="Nombre"
          value={form.nombre}
          onChange={e => setForm({ ...form, nombre: e.target.value })}
        />
        <input
          placeholder="Tipo"
          value={form.tipo}
          onChange={e => setForm({ ...form, tipo: e.target.value })}
        />
        <input
          placeholder="Prima base"
          value={form.primaBase}
          onChange={e => setForm({ ...form, primaBase: e.target.value })}
        />
        <input
          placeholder="Cobertura máxima"
          value={form.coberturaMax}
          onChange={e => setForm({ ...form, coberturaMax: e.target.value })}
        />

        <button onClick={guardar}>
          {editId ? "Actualizar" : "Guardar"}
        </button>

        {editId && (
          <button onClick={() => {
            setEditId(null);
            setForm({ nombre: "", tipo: "", primaBase: "", coberturaMax: "" });
          }}>
            Cancelar edición
          </button>
        )}
      </div>

      <table border="1" cellPadding="6">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Tipo</th>
            <th>Prima</th>
            <th>Cobertura</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {planes.map(p => (
            <tr key={p.id}>
              <td>{p.id}</td>
              <td>{p.nombre}</td>
              <td>{p.tipo}</td>
              <td>{p.primaBase}</td>
              <td>{p.coberturaMax}</td>
              <td>
                <button onClick={() => editar(p)}>Editar</button>
                <button onClick={() => eliminar(p.id)}>Eliminar</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}