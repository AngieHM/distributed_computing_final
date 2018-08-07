/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Boards;
import entity.Followed;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Angela
 */
@Stateless
public class DisplayBoards {

    @EJB
    BoardsRepository boardsRepository;

    
       public DisplayBoards() 
    {
    }
 
    public Boards board() {
        Boards board = boardsRepository.getAllBoards();
        if(board != null) {
            
        }
        
        return board;
    }
    
}
