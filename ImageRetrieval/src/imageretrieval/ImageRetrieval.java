/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageretrieval;
import ALI.*;

/**
 *
 * @author user
 */
public class ImageRetrieval {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VectorLib vlib = new VectorLib();
        ImageLib imgsearch = new ImageLib();
        
        String srcdir="C:\\Users\\user\\Desktop\\animal_dataset\\images/";
        String destdir="C:\\Users\\user\\Desktop\\animal_dataset\\color/";
        String cvqdir="C:\\Users\\user\\Desktop\\animal_dataset\\cvq/";
        String srcfile, destfile;
        
        int[][][]rgb_colors=null;
        double[][]cvq=new double[25][125];
        double[][]images=new double[25][125];
        
        for(int i=0; i<25; i++)
        {
            srcfile=srcdir+"data"+String.valueOf(i)+".jpg";
            rgb_colors=imgsearch.getRGB(srcfile);
            cvq[i]=imgsearch.ColorFeatureExtraction(rgb_colors);
        }
        vlib.saveDST(cvq,"cvq");
        
        for(int i=0; i<25; i++)
        {
            srcfile=srcdir+"data"+String.valueOf(i)+".jpg";
            destfile=cvqdir+"data"+String.valueOf(i)+".jpg";
            imgsearch.RGB_to_CVQ_Image(srcfile, destfile, "jpg", 125);
        }
        
        //Loading color Features
        cvq=vlib.readDST("cvq");
        for(int i=0; i<25; i++)
        {
            destfile=destdir+"cvq"+String.valueOf(i);
            images[i]=vlib.copyArray(cvq[i]);
        }
        
        double[] query=vlib.copyArray(images[23]);
        double[][] hasil=imgsearch.SimilarityMeasurement("cosine", query, images);
        
        vlib.view(hasil);
    }
    
}
