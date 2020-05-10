package br.unicamp.ic.mc322.lab07.agents;

public abstract class Agent {

    private Integer hp;
    private Integer ap;
    private Integer position;
    private String code;
    private Integer i;
    private Integer j;

    public Agent(Integer hp, Integer ap, Integer position, String code) {
        this.hp = hp;
        this.ap = ap;
        this.position = position;
        this.code = code;
        this.i = 0;
        this.j = 0;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getAp() {
        return ap;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getCode() {
        return code;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public Integer getJ() {
        return j;
    }

    public void setJ(Integer j) {
        this.j = j;
    }

    public void attack(Agent agent) {
        if (agent != null) {
            agent.attacked(ap);
        }
    }

    private void attacked(Integer enemyAp) {
        this.hp = hp - enemyAp;
    }

    public boolean destroyed() {
        return hp <= 0;
    }
}
