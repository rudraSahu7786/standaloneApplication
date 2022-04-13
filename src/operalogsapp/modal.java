/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operalogsapp;

/**
 *
 * @author absasahu
 */
public class modal {
    String resort,chainCode,plsqlunit,logText;
    Integer  seqnum,instNum;

    public modal(String resort, String chainCode, String plsqlunit, String logText, Integer seqnum, Integer instNum) {
        this.resort = resort;
        this.chainCode = chainCode;
        this.plsqlunit = plsqlunit;
        this.logText = logText;
        this.seqnum = seqnum;
        this.instNum = instNum;
    }

    public String getResort() {
        return resort;
    }

    public String getChainCode() {
        return chainCode;
    }

    public String getPlsqlunit() {
        return plsqlunit;
    }

    public String getLogText() {
        return logText;
    }

    public Integer getSeqnum() {
        return seqnum;
    }

    public Integer getInstNum() {
        return instNum;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }

    public void setPlsqlunit(String plsqlunit) {
        this.plsqlunit = plsqlunit;
    }

    public void setLogText(String logText) {
        this.logText = logText;
    }

    public void setSeqnum(Integer seqnum) {
        this.seqnum = seqnum;
    }

    public void setInstNum(Integer instNum) {
        this.instNum = instNum;
    }
    
    
    
}
