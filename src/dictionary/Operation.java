package dictionary;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
 class BSTNode
 {
     BSTNode left, right;
     String data;
     public BSTNode()
     {
         left = null;
         right = null;
         data = null;
     }
     public BSTNode(String n)
     {
         left = null;
         right = null;
         data = n;
     }
     public void setLeft(BSTNode n)
     {
         left = n;
     }
     public void setRight(BSTNode n)
     {
         right = n;
     }
     public BSTNode getLeft()
     {
         return left;
     }
     public BSTNode getRight()
     {
         return right;
     }
     public void setData(String d)
     {
         data = d;
     }
     public String getData()
     {
         return data;
     }     
 }
 class BST
 {
     BufferedWriter bw= null;
     private BSTNode root;
     /* Constructor */
     public BST()
     {
         
        root = null;
     }
     /* Function to check if tree is empty */
     public boolean isEmpty()
     {
         return root == null;
     }
     /* Functions to insert data */
     public void insert(String data)
     {
         root = insert(root, data);
     }
     /* Function to insert data recursively */
     private BSTNode insert(BSTNode node, String data)
     {
         if (node == null)
             node = new BSTNode(data);
         else
         {
             if (data.compareTo(node.getData()) <=0 ) //check
                 node.left = insert(node.left, data);
             else
                 node.right = insert(node.right, data);
         }
         return node;
     }
     /* Functions to delete data */
     public void delete(String k)
     {
         if (isEmpty())
             System.out.println("Tree Empty");
         else if (search(k) == false)
             System.out.println("Sorry "+ k +" is not present");
         else
         {
             root = delete(root, k);
             System.out.println(k+ " deleted from the tree");
         }
     }
     private BSTNode delete(BSTNode root, String k)
     {
         BSTNode p, p2, n;
         if (root.getData().compareTo(k)==0)
         {
             BSTNode lt, rt;
             lt = root.getLeft();
             rt = root.getRight();
             if (lt == null && rt == null)
                 return null;
             else if (lt == null)
             {
                 p = rt;
                 return p;
             }
             else if (rt == null)
             {
                 p = lt;
                 return p;
             }
             else
             {
                 p2 = rt;
                 p = rt;
                 while (p.getLeft() != null)
                     p = p.getLeft();
                 p.setLeft(lt);
                 return p2;
             }
         }
         if (k.compareTo(root.getData()) < 0)
         {
             n = delete(root.getLeft(), k);
             root.setLeft(n);
         }
         else
         {
             n = delete(root.getRight(), k);
             root.setRight(n);             
         }
         return root;
     }
     /* Functions to search for an element */
     public boolean search(String val)
     {
         return search(root, val);
     }
     /* Function to search for an element recursively */
     private boolean search(BSTNode r, String val)
     {
         boolean found = false;
         while ((r != null) && !found)
         {
             String rval = r.getData();
             if (val.compareTo(rval) < 0)
                 r = r.getLeft();
             else if (val.compareTo(rval) > 0)
                 r = r.getRight();
             else
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
     /* Function for inorder traversal */
     public void inorder()
     {
         inorder(root);
     }
     private void inorder(BSTNode r)
     {
        FileOutputStream fos = null;
        File fout = null;
         try{
            fout = new File("C:\\Users\\Archit Puri\\Documents\\NetBeansProjects\\Dictionary\\src\\dictionary\\output.txt");
            fos = new FileOutputStream(fout);
            bw = new BufferedWriter(new OutputStreamWriter(fos));
            }
            catch (FileNotFoundException fe)
                {
                System.out.println("Database Error 1");
                }
            catch(IOException ge)
                {
                System.out.println("Database Error 2");
                }
         if (r != null)
         {
             inorder(r.getLeft());
             String p=r.getData();
             try {
                bw.write(p);
                System.out.println(p);
                bw.newLine();
                    }//To write file output
            catch (FileNotFoundException fe)
                {
                System.out.println("Database Error 3");
                }
            catch(IOException ge)
                {
                System.out.println("Database Error 4");
                }
             inorder(r.getRight());
         }
        
     }
 }
 public class Operation
 {
    FileReader in = null;
    BufferedReader br=null;
    //To read file input.txt
    //To read file output
    BST bst = null;
    copier copy; 
    
    void operation(){ 
      try {
         in = new FileReader("C:\\Users\\Archit Puri\\Documents\\NetBeansProjects\\Dictionary\\src\\dictionary\\input.txt");
         br = new BufferedReader(in);
         bst = new BST();
         copy = new copier();
      }
      catch (FileNotFoundException fe)
        {
            System.out.println("Database Error 6");
        }
      /////============================================================================checked till here
      try {
          String p= null;
          while((p=br.readLine())!= null)
          {
               bst.insert(p);//forming full tree
          }
          br.close();
      }
      catch (IOException ie)
      {
          System.out.println("DataBase Error 7");
      }
      }
     boolean insertion(String S)
    {
        boolean success=false;
        bst.insert(S);
        bst.inorder();
        //to write ouput to output.txt
        return success;
    }
    boolean searching(String S)
    {
        boolean success=false;
        success = bst.search(S);
        System.out.println(success);//no need to copy
        return success;
    }
    boolean deletion(String S)
    {
        boolean success=false;
        bst.delete(S);
        bst.inorder();
        //to write ouput to output.txt
        copy.chepo();
        return success;
    }
 }
class copier
{
    FileReader fr = null;
    BufferedReader brv;
    BufferedWriter wrv;
    FileWriter fw = null;
    void chepo()// make different streams copies output.txt file to input.txt
    {
        try
    {  
      fr = new FileReader("C:\\Users\\Archit Puri\\Documents\\NetBeansProjects\\Dictionary\\src\\dictionary\\output.txt");
      fw = new FileWriter("C:\\Users\\Archit Puri\\Documents\\NetBeansProjects\\Dictionary\\src\\dictionary\\input.txt");
      brv= new BufferedReader(fr);
      wrv = new BufferedWriter(fw);
      String k = null;
      while( (k=brv.readLine())!= null )
      {
        System.out.println(k);
        wrv.write(k);
        wrv.newLine();
      }
      fw.close();
      fr.close();
    }
    catch(FileNotFoundException e)
    {
      System.out.println("File does not exist. " + e);
    }
    catch(IOException e)
    {
      System.out.println("Some I/O problem. " + e);
    }
  } 
}