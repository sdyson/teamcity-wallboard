/**
 * Created By:                 Simon Dyson
 * Created:                    22/11/11
 */
package jetbrains.wallboard.model;

import jetbrains.buildServer.messages.Status;
import jetbrains.buildServer.responsibility.ResponsibilityEntry;
import jetbrains.buildServer.serverSide.ResponsibilityInfo;
import jetbrains.buildServer.serverSide.SBuildType;
import jetbrains.buildServer.serverSide.SFinishedBuild;

import java.util.Date;

/**
 *
 * @author Simon Dyson
 */
public class BuildModelImpl implements BuildModel
{
    SBuildType buildType;

// --------------------------- CONSTRUCTORS ---------------------------

    public BuildModelImpl(SBuildType buildType)
    {
        this.buildType = buildType;
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface BuildModel ---------------------

    public String getName()
    {
        return buildType.getName();
    }

    public Date getBuildDate()
    {
        SFinishedBuild finishedBuild = buildType.getLastChangesSuccessfullyFinished();
        return finishedBuild != null ? finishedBuild.getFinishDate() : null;
    }
    
    public String getStatus()
    {
        if(getActive())
        {
            SFinishedBuild finishedBuild = buildType.getLastChangesSuccessfullyFinished();
            return finishedBuild != null ? finishedBuild.getBuildStatus().getText().toLowerCase() : null;
        }
        else
        {
            return Status.UNKNOWN.getText().toLowerCase();
        }
    }
    
    public Boolean getActive()
    {
        return !buildType.isPaused();
    }
    
    public String getResponsible()
    {
        ResponsibilityInfo responsibilityInfo = buildType.getResponsibilityInfo();
        ResponsibilityEntry.State state = responsibilityInfo.getState();
        if(state.isActive() || state.isFixed())
        {
            return responsibilityInfo.getResponsibleUser().getName();
        }
        else
        {
            return null;
        }
    }
}
