package transliteraton;

import java.util.Map;

public class Dictionary
{
    private Map<String, String> mapping;
    private Map<String, String> specific_mapping;

    public Dictionary(Map<String, String> mapping, Map<String, String> specific_mapping) {
	this.mapping = mapping;
	this.specific_mapping = specific_mapping;
    }

    public Map<String, String> getMapping()
    {
	return mapping;
    }

    public void setMapping(Map<String, String> mapping)
    {
	this.mapping = mapping;
    }

    public Map<String, String> getSpecific_mapping()
    {
	return specific_mapping;
    }

    public void setSpecific_mapping(Map<String, String> specific_mapping)
    {
	this.specific_mapping = specific_mapping;
    }

}
