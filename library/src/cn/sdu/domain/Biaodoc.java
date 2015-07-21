package cn.sdu.domain;



/**
 * Biaodoc entity. @author MyEclipse Persistence Tools
 */

public class Biaodoc  implements java.io.Serializable {


    // Fields    

     private Integer bdid;
     private Biaoqian biaoqian;
     private Document document;


    // Constructors

    /** default constructor */
    public Biaodoc() {
    }

    
    /** full constructor */
    public Biaodoc(Biaoqian biaoqian, Document document) {
        this.biaoqian = biaoqian;
        this.document = document;
    }

   
    // Property accessors

    public Integer getBdid() {
        return this.bdid;
    }
    
    public void setBdid(Integer bdid) {
        this.bdid = bdid;
    }

    public Biaoqian getBiaoqian() {
        return this.biaoqian;
    }
    
    public void setBiaoqian(Biaoqian biaoqian) {
        this.biaoqian = biaoqian;
    }

    public Document getDocument() {
        return this.document;
    }
    
    public void setDocument(Document document) {
        this.document = document;
    }
   








}