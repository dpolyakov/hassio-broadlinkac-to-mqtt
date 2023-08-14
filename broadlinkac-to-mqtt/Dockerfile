ARG BUILD_FROM

FROM ${BUILD_FROM}

RUN \
	set -x \
	&& apk add --no-cache --virtual .build-deps \
		git \
		gcc \
		musl-dev \
		python3-dev \
		libffi-dev \
		openssl-dev \
		cargo \
		pkgconfig \
	\
	&& echo "download app" \
	&& git clone --depth=1 \
        https://github.com/liaan/broadlink_ac_mqtt.git /app \
	&& pip install --upgrade pip \
	&& echo "install requirements" \
	&& pip install setuptools_rust \
	&& pip install --no-cache-dir --no-build-isolation -r /app/requirements.txt \
	\
	&& apk del --purge \
		.build-deps \
	&& pip uninstall -y setuptools_rust \
	&& rm -rf \
		/app/.git* \
		/tmp/*

COPY rootfs /

# Build arguments
ARG BUILD_ARCH
ARG BUILD_DATE
ARG BUILD_DESCRIPTION
ARG BUILD_NAME
ARG BUILD_REF
ARG BUILD_REPOSITORY
ARG BUILD_VERSION

# Labels
LABEL \
    io.hass.name="${BUILD_NAME}" \
    io.hass.description="${BUILD_DESCRIPTION}" \
    io.hass.arch="${BUILD_ARCH}" \
    io.hass.type="addon" \
    io.hass.version=${BUILD_VERSION} \
    maintainer="Dmitry Polyakov <github@dimapolyakov.ru>" \
    org.opencontainers.image.title="${BUILD_NAME}" \
    org.opencontainers.image.description="${BUILD_DESCRIPTION}" \
    org.opencontainers.image.vendor="Home Assistant Community Add-ons" \
    org.opencontainers.image.authors="Dmitry Polyakov <github@dimapolyakov.ru>" \
    org.opencontainers.image.licenses="MIT" \
    org.opencontainers.image.source="https://github.com/${BUILD_REPOSITORY}" \
    org.opencontainers.image.documentation="https://github.com/${BUILD_REPOSITORY}/blob/main/README.md" \
    org.opencontainers.image.created=${BUILD_DATE} \
    org.opencontainers.image.revision=${BUILD_REF} \
    org.opencontainers.image.version=${BUILD_VERSION}
