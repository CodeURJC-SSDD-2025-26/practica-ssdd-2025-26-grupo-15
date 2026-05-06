#!/bin/bash

if [ "$#" -lt 1 ] || [ "$#" -gt 2 ]; then
	echo "Use: $0 <DockerHub_username> [tag]"
	echo "Example: $0 isabel 1.0.0"
	exit 1
fi

USERNAME="$1"
TAG="${2:-latest}"

if [ -z "$USERNAME" ] || [ -z "$TAG" ]; then
	echo "Use: $0 <DockerHub_username> [tag]"
	echo "Example: $0 isabel 1.0.0"
	exit 1
fi

# Update docker-compose.yml with new image references
COMPOSE_FILE="docker-compose.yml"

# Create temporary backup
cp "$COMPOSE_FILE" "${COMPOSE_FILE}.bak"

# Update image references in docker-compose.yml
sed -i.tmp "s|dsgram-app-service-app:[^ ]*|dsgram-app-service-app:$TAG|g" "$COMPOSE_FILE"
sed -i.tmp "s|dsgram-pdf-service-app:[^ ]*|dsgram-pdf-service-app:$TAG|g" "$COMPOSE_FILE"

# Clean up sed temporary files
rm -f "${COMPOSE_FILE}.tmp"

echo "Updated docker-compose.yml with tag: $TAG"
echo "Publishing docker-compose.yml to Docker Hub..."

# Uso del comando publish (puede requerir extensiones o ser un comando específico del entorno)
docker compose publish "$USERNAME/dsgram-app-compose:$TAG"

# Restore temporary backup if you want to keep the original tags locally,
# or keep the file and remove the backup:
rm -f "${COMPOSE_FILE}.bak"

echo "Published $USERNAME/dsgram-app-compose:$TAG"