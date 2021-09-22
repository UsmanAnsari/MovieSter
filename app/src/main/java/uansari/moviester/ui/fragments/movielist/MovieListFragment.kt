package uansari.moviester.ui.fragments.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uansari.moviester.databinding.FragmentMovieListBinding
import uansari.moviester.ui.adapters.MovieListAdapter

@AndroidEntryPoint
class MovieListFragment : Fragment() {
    private val movieListViewModel: MovieListViewModel by viewModels()
    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        val movieListAdapter = MovieListAdapter()
        binding.movieListRecyclerview.adapter = movieListAdapter

        movieListViewModel.result.observe(viewLifecycleOwner) {
            movieListAdapter.submitList(it)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}