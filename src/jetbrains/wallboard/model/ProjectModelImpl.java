/**
 * Created By:                 Simon Dyson
 * Created:                    22/11/11
 */
package jetbrains.wallboard.model;

import jetbrains.buildServer.serverSide.SBuildType;
import jetbrains.buildServer.serverSide.SProject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simon Dyson
 */
public class ProjectModelImpl implements ProjectModel
{
    SProject project;
    List<BuildModel> builds = new ArrayList<BuildModel>();

// --------------------------- CONSTRUCTORS ---------------------------

    public ProjectModelImpl(SProject project)
    {
        this.project = project;
        for(SBuildType buildType : project.getBuildTypes())
        {
            builds.add(new BuildModelImpl(buildType));
        }
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface ProjectModel ---------------------

    public List<BuildModel> getBuilds()
    {
        return builds;
    }

    public String getName()
    {
        return project.getName();
    }
    
    public Boolean getActive()
    {
        return !project.isArchived();
    }

    public String getStatus()
    {
        return project.getStatus().getText().toLowerCase();
    }
}
