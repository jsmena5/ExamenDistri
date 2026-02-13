# Etapa 1: build
FROM node:20-alpine AS build

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build

# Etapa 2: producción con nginx
FROM nginx:alpine

# borrar config default
RUN rm /etc/nginx/conf.d/default.conf

# copiar config custom
COPY nginx.conf /etc/nginx/conf.d

# copiar build
COPY --from=build /app/dist /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]