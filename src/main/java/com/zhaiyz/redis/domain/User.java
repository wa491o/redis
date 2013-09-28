package com.zhaiyz.redis.domain;

public class User implements DomainObject {

    private static final long serialVersionUID = -5784761990191887010L;

    public static final String OBJECT_KEY = "USER";

    private String id;

    private String name;

    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getKey() {
        return getId();
    }

    @Override
    public String getObjectKey() {
        return OBJECT_KEY;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
