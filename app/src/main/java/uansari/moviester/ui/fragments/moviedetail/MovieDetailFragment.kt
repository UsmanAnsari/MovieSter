package uansari.moviester.ui.fragments.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import uansari.moviester.databinding.FragmentMovieDetailBinding

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {
    private val movieDetailViewModel: MovieDetailViewModel by viewModels()
    val args: MovieDetailFragmentArgs by navArgs()
    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        movieDetailViewModel.getMoviesDetail(args.movieId.toString())
        movieDetailViewModel.movieDetail.observe(viewLifecycleOwner) {
            binding.movieGenresTxt.text = it.getGenres()
            binding.movieOverviewTxt.text = it.overview
            Picasso.get().load(it.getMovieBanner()).into(binding.moviePosterImg)
            binding.movieRatingBar.rating = it.voteAverage.toFloat()
            binding.movieReleaseDateTxt.text = it.releaseDate
            binding.movieTitleTxt.text = it.originalTitle
            binding.movieWatchTrailerBtn.setOnClickListener { _ ->
                if (it.video) {
                    Toast.makeText(
                        context,
                        "Video Player for trailer is yet to implement",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(context, "No Trailer for Current Movie", Toast.LENGTH_SHORT)
                        .show()
                }

            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}