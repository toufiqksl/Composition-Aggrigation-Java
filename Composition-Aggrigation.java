public class University {

     private List<Department> departments;

     public void destroy(){
         //it's composition, when i destroy a university I also destroy the departments. they cant live outside my university instance
         if(departments!=null)
             for(Department d : departments) d.destroy();
         departments.clean();
         departments = null;
     }
}

public class Department {

     private List<Professor> professors;
     private University university;

     Department(University univ){
         this.university = univ;
         //check here univ not null throw whatever depending on your needs
     }

     public void destroy(){
         //It's aggregation here, we just tell the professor they are fired but they can still keep living
         for(Professor p:professors)
             p.fire(this);
         professors.clean();
         professors = null;
     }
}

public class Professor {

     private String name;
     private List<Department> attachedDepartments;

     public void destroy(){

     }

     public void fire(Department d){
         attachedDepartments.remove(d);
     }
}