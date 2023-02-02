package gr.aueb.cf.testbed.ch19.account.model;

public abstract class AbstractEntity implements IdentifiableEntity {
    private Long id;

    @Override
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
