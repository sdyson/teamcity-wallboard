/**
 * Created By:                 Simon Dyson
 * Created:                    22/11/11
 */
package jetbrains.wallboard.model;

import jetbrains.buildServer.messages.Status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Simple builder class to create sample wallboard data
 *
 * @author Simon Dyson
 */
public class TestWallboardBuilder
{
// --------------------------- CONSTRUCTORS ---------------------------

    public TestWallboardBuilder()
    {
    }

// --------------------- PUBLIC METHODS ---------------------

    public WallboardModel build()
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        WallboardModelVo wallboard = new WallboardModelVo();
        ArrayList<ProjectModel> projects = new ArrayList<ProjectModel>();
        
        ProjectModelVo projectA = new ProjectModelVo();
        projectA.setName("Test Project A");
        ArrayList<BuildModel> buildsA = new ArrayList<BuildModel>();
        
        BuildModelVo buildA1 = new BuildModelVo();
        buildA1.setName("Main Build");
        cal.set(2011, 11, 22, 14, 59);
        buildA1.setBuildDate(cal.getTime());
        buildsA.add(buildA1);
        
        BuildModelVo buildA2 = new BuildModelVo();
        buildA2.setName("Unit Tests");
        cal.set(2011, 11, 22, 14, 59);
        buildA2.setBuildDate(cal.getTime());
        buildsA.add(buildA2);
        
        BuildModelVo buildA3 = new BuildModelVo();
        buildA3.setName("Integration Tests");
        cal.set(2011, 11, 22, 14, 59);
        buildA3.setBuildDate(cal.getTime());
        buildsA.add(buildA3);
        
        BuildModelVo buildA4 = new BuildModelVo();
        buildA4.setName("Inspections");
        cal.set(2011, 11, 22, 14, 59);
        buildA4.setBuildDate(cal.getTime());
        buildsA.add(buildA4);
        
        BuildModelVo buildA5 = new BuildModelVo();
        buildA5.setName("Code Duplicates");
        cal.set(2011, 11, 22, 14, 59);
        buildA5.setBuildDate(cal.getTime());
        buildsA.add(buildA5);
        
        projectA.setBuilds(buildsA);
        projects.add(projectA);
        
        ProjectModelVo projectB = new ProjectModelVo();
        projectB.setName("Test Project B");
        projectB.setStatus(Status.FAILURE.getText().toLowerCase());
        ArrayList<BuildModel> buildsB = new ArrayList<BuildModel>();
        
        BuildModelVo buildB1 = new BuildModelVo();
        buildB1.setName("Main Build");
        cal.set(2011, 11, 22, 14, 59);
        buildB1.setBuildDate(cal.getTime());
        buildsB.add(buildB1);
        
        BuildModelVo buildB2 = new BuildModelVo();
        buildB2.setName("Unit Tests");
        cal.set(2011, 11, 22, 14, 59);
        buildB2.setBuildDate(cal.getTime());
        buildB2.setStatus(Status.FAILURE.getText().toLowerCase());
        buildsB.add(buildB2);
        
        BuildModelVo buildB3 = new BuildModelVo();
        buildB3.setName("Integration Tests");
        cal.set(2011, 11, 22, 14, 59);
        buildB3.setBuildDate(cal.getTime());
        buildsB.add(buildB3);
        
        BuildModelVo buildB4 = new BuildModelVo();
        buildB4.setName("Inspections");
        cal.set(2011, 11, 22, 14, 59);
        buildB4.setBuildDate(cal.getTime());
        buildsB.add(buildB4);
        
        BuildModelVo buildB5 = new BuildModelVo();
        buildB5.setName("Code Duplicates");
        cal.set(2011, 11, 22, 14, 59);
        buildB5.setBuildDate(cal.getTime());
        buildsB.add(buildB5);
        
        projectB.setBuilds(buildsB);
        projects.add(projectB);

        ProjectModelVo projectC = new ProjectModelVo();
        projectC.setName("Test Project C");
        projectC.setStatus(Status.WARNING.getText().toLowerCase());
        ArrayList<BuildModel> buildsC = new ArrayList<BuildModel>();

        BuildModelVo buildC1 = new BuildModelVo();
        buildC1.setName("Main Build");
        cal.set(2011, 11, 22, 14, 59);
        buildC1.setBuildDate(cal.getTime());
        buildC1.setStatus(Status.WARNING.getText().toLowerCase());
        buildsC.add(buildC1);

        BuildModelVo buildC2 = new BuildModelVo();
        buildC2.setName("Unit Tests");
        cal.set(2011, 11, 22, 14, 59);
        buildC2.setBuildDate(cal.getTime());
        buildC2.setResponsible("A. Developer");
        buildsC.add(buildC2);

        BuildModelVo buildC4 = new BuildModelVo();
        buildC4.setName("Inspections");
        cal.set(2011, 11, 22, 14, 59);
        buildC4.setBuildDate(cal.getTime());
        buildsC.add(buildC4);

        BuildModelVo buildC5 = new BuildModelVo();
        buildC5.setName("Code Duplicates");
        cal.set(2011, 11, 22, 14, 59);
        buildC5.setBuildDate(cal.getTime());
        buildsC.add(buildC5);

        projectC.setBuilds(buildsC);
        projects.add(projectC);

        ProjectModelVo projectD = new ProjectModelVo();
        projectD.setName("Test Project D");
        projectD.setStatus(Status.UNKNOWN.getText().toLowerCase());
        ArrayList<BuildModel> buildsD = new ArrayList<BuildModel>();

        BuildModelVo buildD1 = new BuildModelVo();
        buildD1.setName("Main Build");
        cal.set(2011, 11, 22, 14, 59);
        buildD1.setBuildDate(cal.getTime());
        buildsD.add(buildD1);

        BuildModelVo buildD2 = new BuildModelVo();
        buildD2.setName("Unit Tests");
        cal.set(2011, 11, 22, 14, 59);
        buildD2.setBuildDate(cal.getTime());
        buildsD.add(buildD2);

        BuildModelVo buildD3 = new BuildModelVo();
        buildD3.setName("Integration Tests");
        cal.set(2011, 11, 22, 14, 59);
        buildD3.setBuildDate(cal.getTime());
        buildD3.setStatus(Status.UNKNOWN.getText().toLowerCase());
        buildsD.add(buildD3);

        projectD.setBuilds(buildsD);
        projects.add(projectD);

        ProjectModelVo projectE = new ProjectModelVo();
        projectE.setName("Test Project E Long Name");
        projectE.setStatus(Status.ERROR.getText().toLowerCase());
        ArrayList<BuildModel> buildsE = new ArrayList<BuildModel>();

        BuildModelVo buildE1 = new BuildModelVo();
        buildE1.setName("Main Build");
        cal.set(2011, 11, 22, 14, 59);
        buildE1.setBuildDate(cal.getTime());
        buildsE.add(buildE1);

        BuildModelVo buildE2 = new BuildModelVo();
        buildE2.setName("Unit Tests");
        cal.set(2011, 11, 22, 14, 59);
        buildE2.setBuildDate(cal.getTime());
        buildsE.add(buildE2);

        BuildModelVo buildE3 = new BuildModelVo();
        buildE3.setName("Integration Tests");
        cal.set(2011, 11, 22, 14, 59);
        buildE3.setBuildDate(cal.getTime());
        buildE3.setStatus(Status.WARNING.getText().toLowerCase());
        buildsE.add(buildE3);

        BuildModelVo buildE4 = new BuildModelVo();
        buildE4.setName("Inspections");
        cal.set(2011, 11, 22, 14, 59);
        buildE4.setBuildDate(cal.getTime());
        buildE4.setStatus(Status.ERROR.getText().toLowerCase());
        buildsE.add(buildE4);

        projectE.setBuilds(buildsE);
        projects.add(projectE);
        
        wallboard.setProjects(projects);
        return wallboard;
    }
}
