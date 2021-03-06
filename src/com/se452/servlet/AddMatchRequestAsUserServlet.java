package com.se452.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.model.Friendship;
import com.se452.model.MatchType;
import com.se452.model.Status;
import com.se452.service.FriendshipServiceDao;
import com.se452.service.MatchRequestService;

/**
 * Servlet implementation class AddMatchRequestServlet
 */
@WebServlet("/AddMatchRequestAsUserServlet")
public class AddMatchRequestAsUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMatchRequestAsUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        String pageFrom = request.getParameter("pageFrom");

        if (pageFrom.equals("MatchMakerDropDownUpdate"))
        {
            int uid = Integer.parseInt(session.getAttribute("userIdKey").toString());
            FriendshipServiceDao friendService = new FriendshipServiceDao();

            List<Friendship> friendshipList = friendService.getFriendShipList(uid);
            request.setAttribute("friendshipList", friendshipList);

            String matchMakerId = request.getParameter("MatchMakerId");
            List<Friendship> matchMakerfriendshipList = friendService.getFriendShipList(Integer.parseInt(matchMakerId));
            request.setAttribute("matchMakerfriendshipList", matchMakerfriendshipList);
            request.setAttribute("MatchMakerId", matchMakerId);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddMatchRequestAsUser.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            String matchMakerId = request.getParameter("MatchMakerId");
            String user1Id = session.getAttribute("userIdKey").toString();
            String user2Id = request.getParameter("User2Id");
            String RequestType = MatchType.UMU.toString();
            String RequestStatusPending = Status.PENDING.toString();

            MatchRequestService msg = new MatchRequestService();
            try {
                msg.addMatchRequest(Integer.parseInt(matchMakerId), Integer.parseInt(user1Id), Integer.parseInt(user2Id), new Date(), null, RequestStatusPending, RequestType, RequestStatusPending, RequestStatusPending);
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewMatchRequestByUserServlet");
            dispatcher.forward(request, response);
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}