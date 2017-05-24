/*
 * Created on 2007/05/27
 *
 */

/**
 * Then Shen and I did the
 * 
 * Snake Pit
 * 
 * problem. It is a special shortest path problem with several possible
 * solutions. We used the Floyd-Warshall algorithm to find the shortest path
 * from the start to end block. However, you also need to take count of the
 * special plank that can be used anywhere. What we did to cater for the special
 * plank was to make the edge between two connected blocks (already connected
 * with a plank) have a weight of one as usual, but the edges between
 * unconnected blocks have a weight of some large number (this number needs to
 * be large enough). That way you know how many times the plank was used and the
 * paths with the plank used more than once can be discarded as they are not
 * allowed. Another way of solving the problem which some teams used was to find
 * the shortest path going from the start and also from the end and then
 * comparing all possible joining nodes and taking the best one.
 */
public class SnakePit {

}