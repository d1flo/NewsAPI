
package model.thenewsdb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ip",
    "location",
    "domains",
    "as",
    "isp",
    "connectionType"
})
@Generated("jsonschema2pojo")
public class LocationResult {

    @JsonProperty("ip")
    private String ip;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("domains")
    private List<String> domains = null;
    @JsonProperty("as")
    private As as;
    @JsonProperty("isp")
    private String isp;
    @JsonProperty("connectionType")
    private String connectionType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = ip;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("domains")
    public List<String> getDomains() {
        return domains;
    }

    @JsonProperty("domains")
    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    @JsonProperty("as")
    public As getAs() {
        return as;
    }

    @JsonProperty("as")
    public void setAs(As as) {
        this.as = as;
    }

    @JsonProperty("isp")
    public String getIsp() {
        return isp;
    }

    @JsonProperty("isp")
    public void setIsp(String isp) {
        this.isp = isp;
    }

    @JsonProperty("connectionType")
    public String getConnectionType() {
        return connectionType;
    }

    @JsonProperty("connectionType")
    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
