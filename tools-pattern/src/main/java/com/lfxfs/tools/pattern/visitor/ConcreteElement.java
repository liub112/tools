package com.lfxfs.tools.pattern.visitor;

public class ConcreteElement extends Element{
    private String name;

    private Integer level;

    private float momey;

    public ConcreteElement(String name, float momey,Integer level) {
        this.name = name;
        this.momey = momey;
        this.level = level;
    }

    /**
     * Gets the value of level
     *
     * @return the value of level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * Sets the level
     * <p>You can use getLevel() to get the value of level</p>
     *
     * @param level level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * Gets the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * <p>You can use getName() to get the value of name</p>
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of momey
     *
     * @return the value of momey
     */
    public float getMomey() {
        return momey;
    }

    /**
     * Sets the momey
     * <p>You can use getMomey() to get the value of momey</p>
     *
     * @param momey momey
     */
    public void setMomey(float momey) {
        this.momey = momey;
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
