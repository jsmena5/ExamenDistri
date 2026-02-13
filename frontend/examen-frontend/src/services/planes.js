import { api } from "../api/api";

export const planesApi = {
  getAll: () => api.get("/planes"),
  create: (data) => api.post("/planes", data),
  update: (id, data) => api.put(`/planes/${id}`, data),
  delete: (id) => api.delete(`/planes/${id}`)
};