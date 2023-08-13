#!/usr/bin/with-contenv bashio

export SETTINGS_PATH="/data"

bashio::log.info "Generate config file..."

if bashio::config.has_value 'service'; then
tempio \
    -conf "$SETTINGS_PATH/options.json" \
    -template /usr/share/tempio/config.gtpl \
    -out "$SETTINGS_PATH/config.yml"
else
    if ! bashio::fs.directory_exists $SETTINGS_PATH; then
        mkdir -p $SETTINGS_PATH \
            || bashio::exit.nok 'Failed to create data folder'
    fi

    if ! bashio::fs.directory_exists "$SETTINGS_PATH/config.yml"; then
        cp /app/settings/sample_config.yml "$SETTINGS_PATH/config.yml" \
            || bashio::exit.nok 'Failed to create config file'
    fi

fi

if bashio::config.true 'debug'; then
    cat "$SETTINGS_PATH/config.yml"
fi
