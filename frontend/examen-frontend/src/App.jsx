import { useState } from "react";
import ClientesCRUD from "./components/clientes/ClientesCRUD";
import PlanesCRUD from "./components/planes/PlanesCRUD";
import PolizasCRUD from "./components/polizas/PolizasCRUD";

export default function App() {
  const [vista, setVista] = useState("clientes");

  return (
    <div style={{ fontFamily: "Arial", minHeight: "100vh", background: "#f4f6f9" }}>
      <nav style={{ background: "#1e293b", padding: 15, color: "white", display: "flex", gap: 20 }}>
        <b>Examen Seguros</b>
        <button onClick={() => setVista("clientes")}>Clientes</button>
        <button onClick={() => setVista("planes")}>Planes</button>
        <button onClick={() => setVista("polizas")}>Pólizas</button>
      </nav>

      <div style={{ padding: 20 }}>
        {vista === "clientes" && <ClientesCRUD />}
        {vista === "planes" && <PlanesCRUD />}
        {vista === "polizas" && <PolizasCRUD />}
      </div>
    </div>
  );
}