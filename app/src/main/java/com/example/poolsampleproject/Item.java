package com.example.poolsampleproject;

public class Item {
    private String txtDataName;
    private String txtDataUnite;
    private String editTxtValue;

    public String getTxtDataName() {
        return txtDataName;
    }

    public String getTxtDataUnite() {
        return txtDataUnite;
    }

    public String getEditTxtValue()
    {





        return editTxtValue;
    }

    public void setTxtDataName(String txtDataName) {
        this.txtDataName = txtDataName;
    }

    public void setTxtDataUnite(String txtDataUnite) {
        this.txtDataUnite = txtDataUnite;
    }

    public void setEditTxtValue(String editTxtValue) {
        this.editTxtValue = editTxtValue;
    }









    public Item(String txtDataName, String txtDataUnite, String editTxtValue) {
        this.txtDataName = txtDataName;
        this.txtDataUnite = txtDataUnite;
        this.editTxtValue = editTxtValue;
    }
}
