## Configuration

```
  devices:
    - ip: str
      mac: str
      port: port
      name: str
  service:
    daemon_mode: bool
    update_interval: int
    self_discovery: bool?
    bind_to_ip: bool?
  mqtt:
    host: str
    port: port
    user: str?
    password: str?
    client_id: str?
    topic_prefix: str?
    auto_discovery_topic: str?
    auto_discovery_topic_retain: bool?
    discovery: bool?
```
