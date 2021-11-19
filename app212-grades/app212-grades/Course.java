import java.util.ArrayList;
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Amir Azam
 * @version 0.1 11/Sep/2020
 */
public class Course
{
    public final static int MAXN_MODULES = 4;
    
    public ArrayList<Module> modules;
    
    private String code;
    private String title;
    
    private Grades finalGrade;
     
    public Course()
    {
        this("G400", "BSc Computing");
    }
    
    /**
     * Constructor for objects of class Course
     */
    public Course(String code, String title)
    {
        // initialise instance variables
        this.code = code;
        this.title = title;
        
        modules  = new ArrayList<Module>();
        
        createModules();
    }

    /**
     * Create four modules and add them to the
     * modules list for testing purposes.  These
     * must be your four modules.
     */
    public void createModules()
    {
        Module sub1= new Module("co452", "Programming Concepts");
        addModule(sub1);
        Module sub2= new Module("tq453", "Human Resource Mgmnt");
        addModule(sub2);
        Module sub3= new Module("ff788", "Linux Shell Concepts");
        addModule(sub3);
        Module sub4= new Module("py343", "Python Programming");
        addModule(sub4);
    }
    
    public void addModule(Module module)
    {
        if(modules.size() < MAXN_MODULES)
        {
            modules.add(module);
        }
    }
    
    /**
     * 
     */
    public Grades convertToGrade(int mark)
    {
        if(mark >= 1 && mark <= 39)
        {
            return Grades.F;
        }
        else if(mark >= 40 && mark <= 49)
        {
            return Grades.D;
        }
        else if(mark >= 50 && mark <= 59)
        {
            return Grades.C;
        }
        else if(mark >= 60 && mark <= 69)
        {
            return Grades.B;
        }
        else if(mark >= 70 && mark <= 100)
        {
            return Grades.A;
        }
        return Grades.NS;
    }
    
    /**
     * Calculate the average mark from the four module marks
     * and convert that into a final grade.
     */
    public Grades calculateGrade(ArrayList<ModuleMark> marks)
    {
        int s=0;
        for(int i=0; i< marks.size(); i++) {
            s+= marks.get(i).getValue();
        }
        Grades avg = convertToGrade(s/marks.size());
        return avg;
    }
    
    /**
     * Prints out the details of a course and the
     * four modules
     */
    public void print()
    {
        System.out.println();
        System.out.println(" Course " + code + ": " + title);
        //System.out.println();
        
        printModules();
    }
    
    /**
     * Print the course's four modules
     */
    public void printModules()
    {
        System.out.println();
        for(int i=0; i< this.modules.size(); i++) {
            System.out.println("--"+ this.modules.get(i).getTitle());
        }
    }
}
