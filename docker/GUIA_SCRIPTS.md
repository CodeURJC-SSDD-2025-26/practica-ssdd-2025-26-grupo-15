# Guía de Uso - Scripts de Docker

Esta guía explica cómo utilizar los scripts actualizados para crear y publicar imágenes Docker de tus aplicaciones.

---

## 📋 Descripción General

Los scripts han sido actualizados para permitirte trabajar con múltiples aplicaciones (servicios):
- **app-service**: Servicio principal de la aplicación
- **pdf-export-service**: Servicio de exportación a PDF

---

## 🔧 Scripts Disponibles

### 1. `create-image.sh` - Construir imágenes Docker

**Propósito**: Construye una imagen Docker a partir del Dockerfile de una aplicación específica.

#### Parámetros

```bash
./create-image.sh <app-name> <DockerHub_username> [tag]
```

| Parámetro | Requerido | Descripción |
|-----------|-----------|-------------|
| `app-name` | Sí | Nombre de la aplicación: `app-service` o `pdf-export-service` |
| `DockerHub_username` | Sí | Tu usuario de DockerHub |
| `tag` | No | Etiqueta de versión (default: `latest`) |

#### Ejemplos

```bash
# Crear imagen de app-service con tag latest
./create-image.sh app-service tu_usuario

# Crear imagen de app-service con versión específica
./create-image.sh app-service tu_usuario 1.0.0

# Crear imagen de pdf-export-service con versión específica
./create-image.sh pdf-export-service tu_usuario 2.1.5
```

#### Qué hace el script

1. Valida que el nombre de la aplicación sea correcto
2. Localiza el Dockerfile correspondiente:
   - Para `app-service`: `../app-service/docker/Dockerfile`
   - Para `pdf-export-service`: `../pdf-export-service/docker/Dockerfile`
3. Verifica que el Dockerfile exista
4. Construye la imagen con el nombre: `tu_usuario/dsgram-[app-name]:tag`
5. Muestra el progreso durante la construcción

#### Nombres de imágenes generadas

- **app-service**: `tu_usuario/dsgram-app-service-app:tag`
- **pdf-export-service**: `tu_usuario/dsgram-pdf-service-app:tag`

---

### 2. `publish_image.sh` - Publicar imágenes en DockerHub

**Propósito**: Sube una imagen Docker construida a tu repositorio de DockerHub.

#### Parámetros

```bash
./publish_image.sh <app-name> <DockerHub_username> [tag]
```

| Parámetro | Requerido | Descripción |
|-----------|-----------|-------------|
| `app-name` | Sí | Nombre de la aplicación: `app-service` o `pdf-export-service` |
| `DockerHub_username` | Sí | Tu usuario de DockerHub |
| `tag` | No | Etiqueta de versión (default: `latest`) |

#### Ejemplos

```bash
# Publicar app-service con tag latest
./publish_image.sh app-service tu_usuario

# Publicar app-service con versión específica
./publish_image.sh app-service tu_usuario 1.0.0

# Publicar pdf-export-service
./publish_image.sh pdf-export-service tu_usuario 2.1.5
```

#### Requisitos previos

- Debes tener iniciada sesión en DockerHub:
  ```bash
  docker login
  ```
- La imagen debe haber sido construida previamente con `create-image.sh`

---

### 3. `publish_docker-compose.sh` - Actualizar docker-compose.yml

**Propósito**: Actualiza el archivo `docker-compose.yml` con los tags especificados de las imágenes.

#### Parámetros

```bash
./publish_docker-compose.sh <DockerHub_username> [tag]
```

| Parámetro | Requerido | Descripción |
|-----------|-----------|-------------|
| `DockerHub_username` | Sí | Tu usuario de DockerHub |
| `tag` | No | Etiqueta de versión (default: `latest`) |

#### Ejemplos

```bash
# Actualizar docker-compose.yml con tag latest
./publish_docker-compose.sh tu_usuario

# Actualizar con versión específica
./publish_docker-compose.sh tu_usuario 1.0.0
```

#### Qué hace el script

1. Crea un backup del archivo `docker-compose.yml` original
2. Actualiza las referencias de imágenes en el archivo:
   - `dsgram-app-service-app:TAG`
   - `dsgram-pdf-service-app:TAG`
3. Muestra un mensaje de confirmación

---

## 📚 Flujo de Trabajo Típico

### Escenario 1: Construir y publicar una sola aplicación

```bash
# 1. Construir la imagen
./create-image.sh app-service mi_usuario 1.0.0

# 2. Verificar que la imagen se creó correctamente
docker images | grep dsgram-app-service-app

# 3. Publicar en DockerHub (después de hacer login)
docker login
./publish_image.sh app-service mi_usuario 1.0.0
```

### Escenario 2: Construir ambas aplicaciones

```bash
# Construir app-service
./create-image.sh app-service mi_usuario 1.0.0

# Construir pdf-export-service
./create-image.sh pdf-export-service mi_usuario 1.0.0

# Publicar ambas
./publish_image.sh app-service mi_usuario 1.0.0
./publish_image.sh pdf-export-service mi_usuario 1.0.0

# Actualizar docker-compose.yml
./publish_docker-compose.sh mi_usuario 1.0.0
```

### Escenario 3: Desplegar con docker-compose

```bash
# 1. Actualizar docker-compose.yml con nuevos tags
./publish_docker-compose.sh mi_usuario 1.0.0

# 2. Levantar los servicios
docker compose up -d
```

---

## 🐛 Solución de Problemas

### Error: "Dockerfile not found"

**Causa**: El script no encuentra el Dockerfile en la ruta esperada.

**Solución**: Verifica que exista:
- `../app-service/docker/Dockerfile`
- `../pdf-export-service/docker/Dockerfile`

### Error: "Unknown app"

**Causa**: Escribiste mal el nombre de la aplicación.

**Solución**: Usa solo:
- `app-service`
- `pdf-export-service`

### Error en `docker push`: "unauthorized"

**Causa**: No estás autenticado en DockerHub.

**Solución**: Ejecuta:
```bash
docker login
```

### Error en `docker build`: "permission denied"

**Causa**: Permisos insuficientes en los scripts.

**Solución**: Haz los scripts ejecutables:
```bash
chmod +x create-image.sh publish_image.sh publish_docker-compose.sh
```

---

## 📁 Estructura de Directorios

Los scripts esperan la siguiente estructura:

```
docker/
├── create-image.sh
├── publish_image.sh
├── publish_docker-compose.sh
├── docker-compose.yml
└── GUIA_SCRIPTS.md

app-service/
└── docker/
    └── Dockerfile

pdf-export-service/
└── docker/
    └── Dockerfile
```

---

## 💡 Tips Útiles

### 1. Usar alias para simplificar comandos

En tu `~/.bashrc` o `~/.zshrc`:

```bash
alias docker-create='cd ~/ruta/a/docker && ./create-image.sh'
alias docker-publish='cd ~/ruta/a/docker && ./publish_image.sh'
alias docker-compose-update='cd ~/ruta/a/docker && ./publish_docker-compose.sh'
```

### 2. Ver todas las imágenes construidas

```bash
docker images | grep dsgram
```

### 3. Eliminar una imagen local

```bash
docker rmi tu_usuario/dsgram-app-service-app:1.0.0
```

### 4. Ver el historial de docker-compose

```bash
cat docker-compose.yml.bak  # Ver la versión anterior
```

---

## ⚠️ Notas Importantes

1. **Orden de ejecución**: Siempre construye (`create-image.sh`) antes de publicar (`publish_image.sh`)

2. **Tags**: Usa tags descriptivos (ej: `1.0.0`, `2.1.5`) en producción, no solo `latest`

3. **Backup**: El script `publish_docker-compose.sh` crea automáticamente un backup en `docker-compose.yml.bak`

4. **Permisos**: Asegúrate de que tienes permisos para escribir en el repositorio de DockerHub

5. **Ruta de ejecución**: Ejecuta los scripts desde la carpeta `docker/`

---

¿Necesitas ayuda con algún comando específico o tienes dudas adicionales?
