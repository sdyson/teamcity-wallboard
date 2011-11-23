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
        for(SProject sProject : projectManager.getProjects())
        {
            projects.add(new ProjectModelImpl(sProject));
        }
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface WallboardModel ---------------------

    public List<ProjectModel> getProjects()
    {
        return projects;
    }
}
