package common;

import util.Utilitaires;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by ferhat on 2015-11-12.
 */

public class ActionReal {
    public enum Status { ATTENTE,VALIDER,REFUSER,RIEN }
    private User evaluateur;
    private User evaluer;
    private Action action;
    private Date date;
    private String Commentaire;
    private Status status;

    // For internal use only. This id is convenient for the equals() and
    // the hashCode() implementation.
    private final String id;

    public ActionReal(Action action,User evaluateur,User evaluer ){
        this.evaluateur=evaluateur;
        this.evaluer=evaluer;
        this.action=action;
        this.date=new Date();
        status= Status.ATTENTE;

        // The id is set to concatenation of the performer user id and the date time
        // in milliseconds. This value must be unique inside all the distributed
        // system.
        id = evaluer.getId() + date.getTime();
    }
    public User getEvaluateur() {
        return evaluateur;
    }

    public void setEvaluateur(User evaluateur) {
        this.evaluateur = evaluateur;
    }

    public User getEvaluer() {
        return evaluer;
    }

    public void setEvaluer(User evaluer) {
        this.evaluer = evaluer;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCommentaire() {
        return Commentaire;
    }

    public void setCommentaire(String commentaire) {
        Commentaire = commentaire;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActionReal)) return false;

        ActionReal that = (ActionReal) o;

        if (getEvaluateur() != null ? !getEvaluateur().equals(that.getEvaluateur()) : that.getEvaluateur() != null)
            return false;
        return !(getEvaluer() != null ? !getEvaluer().equals(that.getEvaluer()) : that.getEvaluer() != null);

    }

    @Override
    public int hashCode() {
        int result = getEvaluateur() != null ? getEvaluateur().hashCode() : 0;
        result = 31 * result + (getEvaluer() != null ? getEvaluer().hashCode() : 0);
        return result;
    }


}

