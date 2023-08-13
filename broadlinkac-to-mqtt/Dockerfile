ARG BUILD_FROM

FROM ${BUILD_FROM}

RUN \
	set -x \
	&& apk add --no-cache \
		git \
		# py3-pip \
	\
	&& echo "download app" \
	&& git clone --depth=1 \
        https://github.com/liaan/broadlink_ac_mqtt.git /app \
	&& pip install --no-cache-dir --no-build-isolation -r /app/requirements.txt \
	\
	&& apk del --purge \
		git \
		# py3-pip \
	&& rm -rf \
		/app/.git* \
		/tmp/*


RUN addgroup -S aircon && adduser -S aircon -G aircon

COPY rootfs /


# ENTRYPOINT [ "/sbin/tini", "--", "/docker-entrypoint.sh"]
ARG BUILD_ARCH
ARG BUILD_DATE
ARG BUILD_DESCRIPTION
ARG BUILD_NAME
ARG BUILD_REF
ARG BUILD_REPOSITORY
ARG BUILD_VERSION

LABEL \
	maintainer="Dmitry Polyakov" \
	io.hass.name="${BUILD_NAME}" \
    io.hass.description="${BUILD_DESCRIPTION}" \
    io.hass.arch="${BUILD_ARCH}" \
    io.hass.type="addon" \
    io.hass.version=${BUILD_VERSION}
