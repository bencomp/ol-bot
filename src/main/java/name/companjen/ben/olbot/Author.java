package name.companjen.ben.olbot;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 17-5-2014.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Author implements Record {
    private String key;
    private String name;

    @JsonProperty("birth_date")
    private String birthDate;

    @JsonProperty("death_date")
    private String deathDate;
    private Integer revision;

    @JsonProperty("personal_name")
    private String personalName;

    @JsonProperty("eastern_order")
    private Boolean easternOrder;
    @JsonProperty("enumeration")
    private String enumeration;
    @JsonProperty("title")
    private String title;
    @JsonProperty("alternate_names")
    private List<String> alternateNames;
    @JsonProperty("uris")
    private List<String> uris;

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public Integer getRevision() {
        return this.revision;
    }

    @Override
    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public Boolean getEasternOrder() {
        return easternOrder;
    }

    public void setEasternOrder(Boolean easternOrder) {
        this.easternOrder = easternOrder;
    }

    public String getEnumeration() {
        return enumeration;
    }

    public void setEnumeration(String enumeration) {
        this.enumeration = enumeration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAlternateNames() {
        return alternateNames;
    }

    public void setAlternateNames(List<String> alternateNames) {
        this.alternateNames = alternateNames;
    }

    public void addAlternateName(String alternateName) {
        if (this.alternateNames == null) {
            this.alternateNames = new ArrayList<String>();
        }
        this.alternateNames.add(alternateName);
    }
}
