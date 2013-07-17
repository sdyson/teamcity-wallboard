/**
 * Created By:                 Simon Dyson
 * Created:                    22/11/11
 */
package jetbrains.wallboard.model;

import jetbrains.buildServer.serverSide.ProjectManager;
import jetbrains.buildServer.serverSide.SProject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simon Dyson
 */
public class WallboardModelImpl implements WallboardModel
{
    ProjectManager projectManager;
    List<ProjectModel> projects = new ArrayList<ProjectModel>();

// --------------------------- CONSTRUCTORS ---------------------------

    public WallboardModelImpl(ProjectManager projectManager)
    {
        this.projectManager = projectManager;
        for(SProject project : projectManager.getActiveProjects())
        {
            if(!project.isRootProject()) {
                ProjectModelImpl projectModel = new ProjectModelImpl(project);
                if(projectModel.getBuilds().size() > 0)
                {
                    projects.add(projectModel);
                }
            }
        }
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface WallboardModel ---------------------

    public List<ProjectModel> getProjects()
    {
        return projects;
    }
}
