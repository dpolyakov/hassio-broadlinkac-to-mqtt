service:
  daemon_mode: {{ if .service.daemon_mode }}True{{ else }}False{{ end }}
  update_interval: {{ .service.update_interval }}
  self_discovery: {{ if .service.self_discovery }}True{{ else }}False{{ end }}
  bind_to_ip: {{ if .service.bind_to_ip }}{{ .service.bind_to_ip }}{{ else }}False{{ end }}

mqtt:
  host: {{ .mqtt.host }}
  port: {{ .mqtt.port }}
  client_id: {{ .mqtt.client_id }}
  {{ if .mqtt.user }}
  user: {{ .mqtt.user }}
  passwd: {{ .mqtt.password }}
  {{ end }}
  topic_prefix: {{ .mqtt.topic_prefix }}
  auto_discovery_topic: {{ .mqtt.auto_discovery_topic }}
  auto_discovery_topic_retain: {{ if .mqtt.auto_discovery_topic_retain }}True{{ else }}False{{ end }}
  topic_prefix: {{ .mqtt.topic_prefix }}
  auto_discovery_topic: {{ .mqtt.auto_discovery_topic }}
  auto_discovery_topic_retain: {{ if .mqtt.auto_discovery_topic_retain }}True{{ else }}False{{ end }}
  discovery: {{ if .mqtt.discovery }}True{{ else }}False{{ end }}

devices:
{{ range $device := .devices }}
- ip: {{ $device.ip }}
  mac: {{ $device.mac | lower }}
  name: {{ $device.name }}
  port: {{ $device.port }}
{{ end }}