/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageretrievalassignment;
import ALI.*;
/**
 *
 * @author user
 */
public class ImageRetrievalAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VectorLib vlib = new VectorLib();
        ImageLib imgsearch = new ImageLib();
        
        String srcdir="C:\\Users\\user\\Desktop\\corel_dataset\\Image DB/";
        String destdir="C:\\Users\\user\\Desktop\\corel_dataset\\Color DB/";
        String cvqdir="C:\\Users\\user\\Desktop\\corel_dataset\\cvq DB/";
        String srcfile, destfile;
        
        int[][][]rgb_colors=null;
        double[][]cvq=new double[1000][1000];
        double[][]images=new double[1000][1000];
        
        for(int i=0; i<1000; i++)
        {
            srcfile=srcdir+String.valueOf(i)+".jpg";
            rgb_colors=imgsearch.getRGB(srcfile);
            cvq[i]=imgsearch.ColorFeatureExtraction(rgb_colors);
        }
        vlib.saveDST(cvq,"cvq");
        
        for(int i=0; i<1000; i++)
        {
            srcfile=srcdir+String.valueOf(i)+".jpg";
            destfile=cvqdir+String.valueOf(i)+".jpg";
            imgsearch.RGB_to_CVQ_Image(srcfile, destfile, "jpg", 1000);
        }
        
        //Loading color Features
        cvq=vlib.readDST("cvq");
        for(int i=0; i<1000; i++)
        {
            destfile=destdir+"cvq"+String.valueOf(i);
            images[i]=vlib.copyArray(cvq[i]);
        }
        /*
        for(int i=0; i<1000; i++)
        {
            double[] query=vlib.copyArray(images[i]);
            double[][] hasil=imgsearch.SimilarityMeasurement("cosine", query, images);
            vlib.view(hasil);
        }
        */ 
        // Query and Similarity
        int loop;
        for(loop=0; loop<=999; loop++) //Looping dari testing gambar 0-999
        {
        int images_ke = loop;
        double[] query=vlib.copyArray(images[images_ke]);
        double[][] hasil=imgsearch.SimilarityMeasurement("cosine", query, images);
        vlib.view(hasil);
        
        // 15 Top Correct Retrieved Images
        String categories = "None";
        int[] Score = {0,0};
        //int score[1]=0;
        //int score[2]=0;
        //int score[3]=0; int score[4]=0;int score[5]=0;int score[6]=0;int score[7]=0;int score[8]=0;
        //int score[9]=0;int score[10]=0;
        int Score_persent;
        int[] Error = {0,0};
        int TotalError;
        
        //System.out.print("\n Top 15 Images: ");
        for (int i=0; i<15; i++)
        {
            //System.out.print("\n"+hasil[1][i]+", ");
            
            // Categories and Scoring
            if (images_ke >=0 && images_ke <= 99)
            {
                categories = "People";
                // Scoring
                if (hasil[1][i] >= 0.0 && hasil[1][i] <= 99.0)
                {
                    //Utk yg cocok gambar testing=hasil
                    Score[1]=Score[1]+15-i+1;
                    Error[1]=Error[1]+1;
                    //System.out.print("\n Score[1]= "+Score[1]);
                    //System.out.print("\n Error[1]= "+Error[1]);
                }
            }
            else if (images_ke >=100 &&images_ke <= 199)
            {
                categories = "beaches";
                if (hasil[1][i] >= 100.0 && hasil[1][i] <= 199.0)
                {
                    //Utk yg cocok gambar testing=hasil
                    Score[1]=Score[1]+15-i+1;
                    Error[1]=Error[1]+1;
                    //System.out.print("\n Score[1]= "+Score[1]);
                    //System.out.print("\n Error[1]= "+Error[1]);
                }
                
            }
            else if (images_ke >=200 &&images_ke <= 299)
            {
                categories = "historian buildings";
                if (hasil[1][i] >= 200.0 && hasil[1][i] <= 299.0)
                {
                    //Utk yg cocok gambar testing=hasil
                    Score[1]=Score[1]+15-i+1;
                    Error[1]=Error[1]+1;
                    //System.out.print("\n Score[1]= "+Score[1]);
                    //System.out.print("\n Error[1]= "+Error[1]);
                }

            }
            else if (images_ke >=300 && images_ke <= 399)
            {
                categories = "buses";
                if (hasil[1][i] >= 300.0 && hasil[1][i] <= 399.0)
                {
                    Score[1]=Score[1]+15-i+1;
                    Error[1]=Error[1]+1;
                    //System.out.print("\n Score[1]= "+Score[1]);
                    //System.out.print("\n Error[1]= "+Error[1]);
                }
            }
            else if (images_ke >=400 &&images_ke <= 499)
            {
                categories = "dinosaurs";
                if (hasil[1][i] >= 400.0 && hasil[1][i] <= 499.0)
                {
                    //Utk yg cocok gambar testing=hasil
                    Score[1]=Score[1]+15-i+1;
                    Error[1]=Error[1]+1;
                    //System.out.print("\n Score[1]= "+Score[1]);
                    //System.out.print("\n Error[1]= "+Error[1]);
                }
            }
            else if (images_ke >=500 &&images_ke <= 599)
            {
                categories = "elephants";
                if (hasil[1][i] >= 500.0 && hasil[1][i] <= 599.0)
                {
                    //Utk yg cocok gambar testing=hasil
                    Score[1]=Score[1]+15-i+1;
                    Error[1]=Error[1]+1;
                    //System.out.print("\n Score[1]= "+Score[1]);
                    //System.out.print("\n Error[1]= "+Error[1]);
                }
            }
            else if (images_ke >=600 &&images_ke <= 699)
            {
                categories = "roses";
                if (hasil[1][i] >= 600.0 && hasil[1][i] <= 699.0)
                {
                    //Utk yg cocok gambar testing=hasil
                    Score[1]=Score[1]+15-i+1;
                    Error[1]=Error[1]+1;
                    //System.out.print("\n Score[1]= "+Score[1]);
                    //System.out.print("\n Error[1]= "+Error[1]);
                }
            }
            else if (images_ke >=700 &&images_ke <= 799)
            {
                categories = "horses";
                if (hasil[1][i] >= 700.0 && hasil[1][i] <= 799.0)
                {
                    //Utk yg cocok gambar testing=hasil
                    Score[1]=Score[1]+15-i+1;
                    Error[1]=Error[1]+1;
                    //System.out.print("\n Score[1]= "+Score[1]);
                    //System.out.print("\n Error[1]= "+Error[1]);
                }
            }
            else if (images_ke >=800 &&images_ke <= 899)
            {
                categories = "mountains";
                if (hasil[1][i] >= 800.0 && hasil[1][i] <= 899.0)
                {
                    //Utk yg cocok gambar testing=hasil
                    Score[1]=Score[1]+15-i+1;
                    Error[1]=Error[1]+1;
                    //System.out.print("\n Score[1]= "+Score[1]);
                    //System.out.print("\n Error[1]= "+Error[1]);
                }
            }
            else if (images_ke >=900 &&images_ke <= 999)
            {
                categories = "foods";
                if (hasil[1][i] >= 900.0 && hasil[1][i] <= 999.0)
                {
                    //Utk yg cocok gambar testing=hasil
                    Score[1]=Score[1]+15-i+1;
                    Error[1]=Error[1]+1;
                    //System.out.print("\n Score[1]= "+Score[1]);
                    //System.out.print("\n Error[1]= "+Error[1]);
                }
            }            
        }
        
        // Scoring
        System.out.print("\n Images ke-" + images_ke);
        System.out.print("\n Categories: " + categories);
        Score_persent = Score[1];
        TotalError=15-Error[1];
        System.out.print("\n Score: " + Score[1]);
        System.out.print("\n Error: " + TotalError+"\n");
        
    }
    }
}
