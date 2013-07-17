/**
 * Created By:                 Simon Dyson
 * Created:                    22/11/11
 */
package jetbrains.wallboard.model;

import jetbrains.buildServer.messages.Status;
import jetbrains.buildServer.responsibility.ResponsibilityEntry;
import jetbrains.buildServer.serverSide.SBuildType;
import jetbrains.buildServer.serverSide.SFinishedBuild;
import jetbrains.buildServer.vcs.SVcsModification;

import java.util.Date;
import java.util.List;

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
        SFinishedBuild finishedBuild = buildType.getLastChangesFinished();
        return finishedBuild != null ? finishedBuild.getFinishDate() : null;
    }

    public String getStatus()
    {
        Status buildStatus = getBuildStatus();
        return buildStatus != null ? buildStatus.getText().toLowerCase() : null;
    }

    public Boolean getActive()
    {
        return !buildType.isPaused();
    }

    public String getResponsible()
    {
        ResponsibilityEntry responsibilityInfo = buildType.getResponsibilityInfo();
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

    public String getTimeBroken()
    {
        if(getBuildStatus().isFailed())
        {
            Date buildDate = getBuildDate();
            Date now = new Date();
            long millis = now.getTime() - buildDate.getTime();
            long secs = millis / 1000;
            if(secs < 60)
            {
                return secs + "s";
            }
            else
            {
                long mins = secs / 60;
                if(mins < 60)
                {
                    return mins + "m";
                }
                else
                {
                    long hours = mins / 60;
                    if(hours < 24)
                    {
                        return hours + "h";
                    }
                    else
                    {
                        long days = hours / 24;
                        return days + "d";
                    }
                }
            }
        }
        return null;
    }

    public Status getBuildStatus()
    {
        SFinishedBuild finishedBuild = buildType.getLastChangesFinished();
        return finishedBuild != null ? finishedBuild.getBuildStatus() : null;
    }

    public String getPendingChanges()
    {
        List<SVcsModification> pendingChanges = buildType.getPendingChanges();
        if(pendingChanges != null && !pendingChanges.isEmpty())
        {
            return "(" + pendingChanges.size() + ")";
        }
        else
        {
            return null;
        }
    }
    
    public boolean isRunning()
    {
        return !buildType.getRunningBuilds().isEmpty();
    }
}
