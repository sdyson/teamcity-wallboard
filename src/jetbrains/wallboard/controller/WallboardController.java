/**
 * Created By:                 Simon Dyson
 * Created:                    22/11/11
 */
package jetbrains.wallboard.controller;

import jetbrains.buildServer.controllers.BaseController;
import jetbrains.buildServer.serverSide.SBuildServer;
import jetbrains.buildServer.web.openapi.WebControllerManager;
import jetbrains.wallboard.model.TestWallboardBuilder;
import jetbrains.wallboard.model.WallboardModelImpl;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 *
 * @author Simon Dyson
 */
public class WallboardController extends BaseController
{
    private final WebControllerManager myManager;

    public WallboardController(SBuildServer sBuildServer, WebControllerManager manager)
    {
        super(sBuildServer);
        myManager = manager;

    }

    /**
     * @param httpServletRequest  http request
     * @param httpServletResponse http response
     * @return object containing model object and view
     * @throws Exception
     */
    protected ModelAndView doHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
        throws Exception
    {
        HashMap<String, Object> params = new HashMap<String, Object>();
        String test = httpServletRequest.getParameter("test");
        if(test != null && test.equals("true"))
        {
            // Test model to cover most cases
            params.put("model", new TestWallboardBuilder().build());
        }
        else
        {
            params.put("model", new WallboardModelImpl(myServer.getProjectManager()));
        }
        return new ModelAndView("/plugins/wallboard/wallboard.jsp", params);
    }

    public void register()
    {
        myManager.registerController("/wallboard.html", this);
    }
}
