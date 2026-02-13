import { api } from "../api/api";

export const polizasApi = {
  getAll: () => api.get("/polizas"),
  emitir: (data) => api.post("/polizas", data),
  cancelar: (id) => api.put(`/polizas/${id}/cancelar`)
};