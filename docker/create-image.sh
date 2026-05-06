#!/bin/bash

if [ "$#" -lt 2 ] || [ "$#" -gt 3 ]; then
	echo "Use: $0 <app-name> <DockerHub_username> [tag]"
	echo "Example: $0 app-service isabel 1.0.0"
	echo "Example: $0 pdf-export-service isabel 1.0.0"
	exit 1
fi

APP_NAME="$1"
USERNAME="$2"
TAG="${3:-latest}"

# Validate app name and find Dockerfile
case "$APP_NAME" in
	app-service)
		DOCKERFILE_PATH="../app-service/docker/Dockerfile"
		IMAGE_NAME="$USERNAME/dsgram-app-service-app:$TAG"
		;;
	pdf-export-service)
		DOCKERFILE_PATH="../pdf-export-service/docker/Dockerfile"
		IMAGE_NAME="$USERNAME/dsgram-pdf-service-app:$TAG"
		;;
	*)
		echo "Error: Unknown app '$APP_NAME'"
		echo "Available apps: app-service, pdf-export-service"
		exit 1
		;;
esac

if [ -z "$USERNAME" ] || [ -z "$TAG" ] || [ -z "$APP_NAME" ]; then
	echo "Use: $0 <app-name> <DockerHub_username> [tag]"
	echo "Example: $0 app-service isabel 1.0.0"
	exit 1
fi

if [ ! -f "$DOCKERFILE_PATH" ]; then
	echo "Error: Dockerfile not found at $DOCKERFILE_PATH"
	exit 1
fi

echo "Building Docker image: $IMAGE_NAME"
echo "Using Dockerfile: $DOCKERFILE_PATH"

docker build -f "$DOCKERFILE_PATH" -t "$IMAGE_NAME" "../$APP_NAME"