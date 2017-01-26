package model;

/**
 * Created by igor on 26.1.17.
 */
public class Vote {

    private Long id;
    private String nameVote;
    private Long countYes;
    private Long countNo;
    private boolean checkVote;

    public Vote() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameVote() {
        return nameVote;
    }

    public void setNameVote(String nameVote) {
        this.nameVote = nameVote;
    }

    public Long getCountYes() {
        return countYes;
    }

    public void setCountYes(Long countYes) {
        this.countYes = countYes;
    }

    public Long getCountNo() {
        return countNo;
    }

    public void setCountNo(Long countNo) {
        this.countNo = countNo;
    }

    public boolean isCheckVote() {
        return checkVote;
    }

    public void setCheckVote(boolean checkVote) {
        this.checkVote = checkVote;
    }
}
