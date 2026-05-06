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

# Validate app name
case "$APP_NAME" in
	app-service)
		IMAGE_NAME="$USERNAME/dsgram-app-service-app:$TAG"
		;;
	pdf-export-service)
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

echo "Pushing Docker image: $IMAGE_NAME"

docker push "$IMAGE_NAME"