import { useState } from "react";
import { clientesApi } from "../../services/clientes";

export default function ClientesCRUD() {
  const [form, setForm] = useState({ nombres: "", identificacion: "", email: "", telefono: "" });
  const [msg, setMsg] = useState("");

  const guardar = async () => {
    if(!form.nombres || !form.identificacion || !form.email || !form.telefono) {
      setMsg(" Todos los campos son obligatorios");
      return;
    }
    await clientesApi.create(form);
    setForm({ nombres: "", identificacion: "", email: "", telefono: "" });
    setMsg("Cliente creado correctamente");
  };

  return (
    <div className="card">
      <h2>Crear Cliente</h2>
      {msg && <div className="alert">{msg}</div>}
      <input placeholder="Nombres" value={form.nombres} onChange={e=>setForm({...form,nombres:e.target.value})}/>
      <input placeholder="Identificación" value={form.identificacion} onChange={e=>setForm({...form,identificacion:e.target.value})}/>
      <input placeholder="Email" value={form.email} onChange={e=>setForm({...form,email:e.target.value})}/>
      <input placeholder="Teléfono" value={form.telefono} onChange={e=>setForm({...form,telefono:e.target.value})}/>
      <button onClick={guardar}>Crear Cliente</button>
    </div>
  );
}