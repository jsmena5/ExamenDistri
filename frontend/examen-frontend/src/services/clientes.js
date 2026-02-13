import { api } from "../api/api";

export const clientesApi = {
  getAll: () => api.get("/clientes"),
  create: (data) => api.post("/clientes", data),
  update: (id, data) => api.put(`/clientes/${id}`, data),
  delete: (id) => api.delete(`/clientes/${id}`)
};