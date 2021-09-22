package uansari.moviester.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uansari.moviester.R
import uansari.moviester.data.models.upcoming.Result
import uansari.moviester.databinding.MovieListItemBinding
import uansari.moviester.ui.fragments.movielist.MovieListFragmentDirections

class MovieListAdapter :
    ListAdapter<Result, MovieListAdapter.ViewHolder>(ResultDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MovieListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = getItem(position)
        with(result) {
            Picasso.get().load(this.getMoviePoster()).placeholder(R.drawable.movie)
                .into(holder.poster)
            holder.title.text = this.title
            holder.date.text = this.releaseDate
            holder.adultStatus.text = this.adultStatus()
            holder.poster.setOnClickListener {
                it.findNavController().navigate(
                    MovieListFragmentDirections.actionMovieListFragmentToMovieDetailFragment(this.id)
                )
            }
            holder.container.setOnClickListener {
                it.findNavController().navigate(
                    MovieListFragmentDirections.actionMovieListFragmentToMovieDetailFragment(this.id)
                )
            }
        }
    }


    inner class ViewHolder(private val binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val container = binding.movieDataContainer
        val poster = binding.moviePosterImg
        val title = binding.movieTitleTxt
        val date = binding.movieReleaseDateTxt
        val adultStatus = binding.movieAdultStatusTxt
        val bookBtn = binding.movieBookBtn
    }
}

private class ResultDiffCallBack : DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem == newItem
    }
}