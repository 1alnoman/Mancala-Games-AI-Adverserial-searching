# Mancala-Games-AI-Adverserial-searching

# I have built an AI agent that plays a Mancala game. We applied an adversarial searching algorithm to implement that agent. We can set the complexity of the agent by increasing depth.

## The Minimax algorithm is a popular algorithm for Adversarial learning that operates on the principle of minimizing the possible loss for a worst-case scenario. It assumes that both players are playing optimally. The algorithm recursively evaluates all possible moves. The time complexity of Minimax is O(b^d), where b is the branching factor and d is the depth of the tree. This is the limitation of min max algorithm.

## Alpha-beta pruning is an optimization technique for the minimax algorithm. It reduces the number of nodes evaluated in the game tree by eliminating branches that cannot influence the final decision. This is achieved by maintaining two values, alpha and beta, which represent the minimum score that the maximizing player is assured of and the maximum score that the minimizing player is assured of, respectively.

## Alpha: The best (highest) value that the maximizer can guarantee given the current state.
## Beta: The best (lowest) value that the minimizer can guarantee given the current state.
