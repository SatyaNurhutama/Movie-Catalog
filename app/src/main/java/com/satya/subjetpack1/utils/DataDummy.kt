package com.satya.subjetpack1.utils

import com.satya.subjetpack1.data.source.local.entity.MovieEntity
import com.satya.subjetpack1.data.source.local.entity.MovieWithId
import com.satya.subjetpack1.data.source.local.entity.TvEntity
import com.satya.subjetpack1.data.source.local.entity.TvWithId
import com.satya.subjetpack1.data.source.remote.response.MovieResponse
import com.satya.subjetpack1.data.source.remote.response.TvResponse

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                "a01",
                "Sonic the Hedgehog",
                "Mengisahkan petualangan Sonic saat ia belajar tentang kompleksitas kehidupan di bumi bersama manusia sahabat barunya, Tom Wachowski. Sonic dan Tom bersatu untuk menghentikan si jahat Dr. Robotnik yang ingin menangkap Sonic dan menggunakan kekuatan istimewanya untuk menguasai dunia.",
                "Film anak-anak , Animasi , Laga, Petualangan, Film Komedi",
                "2020",
                "6/10",
                "99 menit",
                false,
                "https://m.media-amazon.com/images/M/MV5BMDk5Yzc4NzMtODUwOS00NTdhLTg2MjEtZTkzZjc0ZWE2MzAwXkEyXkFqcGdeQXVyMTA3MTA4Mzgw._V1_.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "a02",
                "Demon Slayer: Kimetsu no Yaiba the Movie: Mugen Train",
                "Tanjiro Kamado, bergabung dengan Inosuke Hashibira, seorang anak laki-laki yang dibesarkan oleh babi hutan yang memakai kepala babi hutan, dan Zenitsu Agatsuma, seorang anak laki-laki ketakutan yang mengeluarkan kekuatan sejatinya ketika dia tidur, di dalam Kereta Infinity dalam misi baru dengan seorang Pilar Api, Kyojuro Rengoku , Untuk mengalahkan iblis yang telah menyiksa orang-orang dan membunuh pembunuh iblis yang menentangnya!",
                "Anime, Animasi, Laga, Petualangan, Film Fantasi",
                "2020",
                "9/10",
                "2 jam",
                false,
                "https://static.wikia.nocookie.net/kimetsu-no-yaiba/images/1/13/Mugen_Train_Poster_3.png/revision/latest?cb=20201027083821"
            )
        )

        movies.add(
            MovieEntity(
                "a03",
                "Mulan",
                "Ketika kaisar Tiongkok mengeluarkan dekrit bahwa satu pria dari setiap keluarga wajib bergabung dalam tentara kekaisaran untuk mempertahankan negara dari serangan bangsa Hun, Hua Mulan, putri tertua dari seorang pejuang terhormat, memutuskan menggantikan ayahnya yang sakit-sakitan.",
                "Laga, Petualangan, Drama, Film Fantasi",
                "2020",
                "7/10",
                "2 jam",
                false,
                "https://images-na.ssl-images-amazon.com/images/I/81fFRUvEJDL._AC_SY879_.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "a04",
                "Avengers: Endgame",
                "Melanjutkan Avengers Infinity War, dimana kejadian setelah Thanos berhasil mendapatkan semua infinity stones dan memusnahkan 50% semua mahluk hidup di alam semesta. Akankah para Avengers berhasil mengalahkan Thanos?",
                "Laga, Petualangan, Film Pahlawan Super, Film Fantasi, Fiksi Ilmiah",
                "2019",
                "9/10",
                "3 jam 2 menit",
                false,
                "https://images-na.ssl-images-amazon.com/images/I/81ai6zx6eXL._AC_SL1304_.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "a05",
                "Avengers: Infinity War",
                "The Avengers dan sekutu mereka harus bersedia mengorbankan segalanya dalam upaya untuk mengalahkan Thanos yang kuat sebelum ia berhasil menghancurkan alam semesta.",
                "Laga, Petualangan, Film Pahlawan Super, Film Fantasi, Fiksi Ilmiah",
                "2018",
                "9/10",
                "2 jam 40 menit",
                false,
                "https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_UY1200_CR90,0,630,1200_AL_.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "a06",
                "Spider-Man: Far From Home",
                "Peter Parker (Tom Holland) tengah mengunjungi Eropa untuk liburan panjang bersama temaan-temanya. Sayangnya , Parker tidak bisa dengan tenang menikmati liburannya, karena Nick Fury datang secara tiba-tiba di kamar hotelnya. Selama di Eropa pun Peter harus menghadapi banyak musuh mulai dari Hydro Man, Sandman dan Molten Man.",
                "Laga, Petualangan, Film Pahlawan Super, Film Fantasi, Fiksi Ilmiah, Film Komedi, Remaja",
                "2019",
                "9/10",
                "2 jam 9 menit",
                false,
                "https://asset-a.grid.id/crop/0x0:0x0/700x0/photo/2019/05/23/1626860820.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "a07",
                "Parasite",
                "Keluarga Ki-taek beranggotakan empat orang pengangguran dengan masa depan suram menanti mereka. Suatu hari Ki-woo anak laki-laki tertua direkomendasikan oleh sahabatnya yang merupakan seorang mahasiswa dari universitas bergengsi agar Ki-woo menjadi guru les yang dibayar mahal dan membuka secercah harapan penghasilan tetap. Dengan penuh restu serta harapan besar dari keluarga, Ki-woo menuju ke rumah keluarga Park untuk wawancara. Setibanya di rumah Mr. Park pemilik perusahaan IT global, Ki-woo bertemu dengan Yeon-kyo, wanita muda yang cantik di rumah itu. Setelah pertemuan itu, serangkaian kejadian dimulai.",
                "Drama, Film Komedi, Misteri, Komedi Hitam, Cerita Seru",
                "2019",
                "9/10",
                "2 jam 12 menit",
                false,
                "https://assets.mubicdn.net/images/notebook/post_images/29836/images-w1400.jpg?1579571205"
            )
        )

        movies.add(
            MovieEntity(
                "a08",
                "Joker",
                "Arthur Fleck, seorang badut pesta, hidup dalam keadaan sulit bersama ibunya yang sakit-sakitan. Karena orang-orang menganggapnya aneh, ia memutuskan untuk berubah menjadi jahat dan membuat kekacauan.",
                "Drama, Cerita Seru, Kejahatan",
                "2019",
                "9/10",
                "2 jam 2 menit",
                false,
                "https://cdn.cgv.id/uploads/movie/pictures/19029600.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "a09",
                "Your Name",
                "Alur. Mitsuha Miyamizu, seorang siswi sekolah menengah atas yang tinggal di desa fiktif bernama Itomori di daerah pegunungan Hida Prefektur Gifu, mulai bosan dengan kehidupannya di pedesaan tempat dia lahir dan berharap dapat terlahir menjadi pemuda tampan yang hidup di Tokyo pada kehidupan selanjutnya.",
                "Anime, Roman, Drama, Animasi, Film Fantasi",
                "2016",
                "9/10",
                "1 jam 52 menit",
                false,
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSdCn7P_niNCbNFHt9vLgDc-YlRIhwvnCPtHzyiHVP_GK-XmDS1"
            )
        )

        movies.add(
            MovieEntity(
                "a10",
                "Pokemon: Detective Pikachu",
                "Kisah ini bermula ketika detektif swasta ulung Harry Goodman menghilang secara tiba-tiba, mendorong putranya yang berumur 21 tahun untuk mencari tahu apa yang terjadi. Yang membantu penyelidikan adalah mantan mitra Pokmon Harry, Detective Pikachu: detektif ulung yang kocak dan menggemaskan yang membingungkan bahkan bagi dirinya sendiri. Mereka menemukan bahwa mereka saling melengkapi secara unik untuk berkomunikasi satu sama lain, Tim dan Pikachu bergabung dalam sebuah petualangan mendebarkan untuk mengungkap misteri yang kusut. Mengejar petunjuk bersama menyusuri jalan- jalan di Ryme City yang terang benderangsebuah kota metropolitan modern yang luas di mana manusia dan Pokmon hidup berdampingan dalam sebuah dunia hiper-realistismereka menghadapi beragam karakter Pokmon dan mengungkap plot mengejutkan yang bisa menghancurkan ko-eksistensi yang damai dan mengancam seluruh alam semesta Pokmon.",
                "Film anak-anak, Petualangan, Laga, Misteri, Animasi, Fiksi Ilmiah, Film Fantasi",
                "2019",
                "9/10",
                "1 jam 45 menit",
                false,
                "https://images-na.ssl-images-amazon.com/images/I/51MfhHo5CYL.jpg"
            )
        )

        return movies
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {

        val movies = ArrayList<MovieResponse>()

        movies.add(
            MovieResponse(
                "a01",
                "Sonic the Hedgehog",
                "Mengisahkan petualangan Sonic saat ia belajar tentang kompleksitas kehidupan di bumi bersama manusia sahabat barunya, Tom Wachowski. Sonic dan Tom bersatu untuk menghentikan si jahat Dr. Robotnik yang ingin menangkap Sonic dan menggunakan kekuatan istimewanya untuk menguasai dunia.",
                "Film anak-anak , Animasi , Laga, Petualangan, Film Komedi",
                "2020",
                "6/10",
                "99 menit",
                "https://m.media-amazon.com/images/M/MV5BMDk5Yzc4NzMtODUwOS00NTdhLTg2MjEtZTkzZjc0ZWE2MzAwXkEyXkFqcGdeQXVyMTA3MTA4Mzgw._V1_.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "a02",
                "Demon Slayer: Kimetsu no Yaiba the Movie: Mugen Train",
                "Tanjiro Kamado, bergabung dengan Inosuke Hashibira, seorang anak laki-laki yang dibesarkan oleh babi hutan yang memakai kepala babi hutan, dan Zenitsu Agatsuma, seorang anak laki-laki ketakutan yang mengeluarkan kekuatan sejatinya ketika dia tidur, di dalam Kereta Infinity dalam misi baru dengan seorang Pilar Api, Kyojuro Rengoku , Untuk mengalahkan iblis yang telah menyiksa orang-orang dan membunuh pembunuh iblis yang menentangnya!",
                "Anime, Animasi, Laga, Petualangan, Film Fantasi",
                "2020",
                "9/10",
                "2 jam",
                "https://static.wikia.nocookie.net/kimetsu-no-yaiba/images/1/13/Mugen_Train_Poster_3.png/revision/latest?cb=20201027083821"
            )
        )

        movies.add(
            MovieResponse(
                "a03",
                "Mulan",
                "Ketika kaisar Tiongkok mengeluarkan dekrit bahwa satu pria dari setiap keluarga wajib bergabung dalam tentara kekaisaran untuk mempertahankan negara dari serangan bangsa Hun, Hua Mulan, putri tertua dari seorang pejuang terhormat, memutuskan menggantikan ayahnya yang sakit-sakitan.",
                "Laga, Petualangan, Drama, Film Fantasi",
                "2020",
                "7/10",
                "2 jam",
                "https://images-na.ssl-images-amazon.com/images/I/81fFRUvEJDL._AC_SY879_.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "a04",
                "Avengers: Endgame",
                "Melanjutkan Avengers Infinity War, dimana kejadian setelah Thanos berhasil mendapatkan semua infinity stones dan memusnahkan 50% semua mahluk hidup di alam semesta. Akankah para Avengers berhasil mengalahkan Thanos?",
                "Laga, Petualangan, Film Pahlawan Super, Film Fantasi, Fiksi Ilmiah",
                "2019",
                "9/10",
                "3 jam 2 menit",
                "https://images-na.ssl-images-amazon.com/images/I/81ai6zx6eXL._AC_SL1304_.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "a05",
                "Avengers: Infinity War",
                "The Avengers dan sekutu mereka harus bersedia mengorbankan segalanya dalam upaya untuk mengalahkan Thanos yang kuat sebelum ia berhasil menghancurkan alam semesta.",
                "Laga, Petualangan, Film Pahlawan Super, Film Fantasi, Fiksi Ilmiah",
                "2018",
                "9/10",
                "2 jam 40 menit",
                "https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_UY1200_CR90,0,630,1200_AL_.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "a06",
                "Spider-Man: Far From Home",
                "Peter Parker (Tom Holland) tengah mengunjungi Eropa untuk liburan panjang bersama temaan-temanya. Sayangnya , Parker tidak bisa dengan tenang menikmati liburannya, karena Nick Fury datang secara tiba-tiba di kamar hotelnya. Selama di Eropa pun Peter harus menghadapi banyak musuh mulai dari Hydro Man, Sandman dan Molten Man.",
                "Laga, Petualangan, Film Pahlawan Super, Film Fantasi, Fiksi Ilmiah, Film Komedi, Remaja",
                "2019",
                "9/10",
                "2 jam 9 menit",
                "https://asset-a.grid.id/crop/0x0:0x0/700x0/photo/2019/05/23/1626860820.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "a07",
                "Parasite",
                "Keluarga Ki-taek beranggotakan empat orang pengangguran dengan masa depan suram menanti mereka. Suatu hari Ki-woo anak laki-laki tertua direkomendasikan oleh sahabatnya yang merupakan seorang mahasiswa dari universitas bergengsi agar Ki-woo menjadi guru les yang dibayar mahal dan membuka secercah harapan penghasilan tetap. Dengan penuh restu serta harapan besar dari keluarga, Ki-woo menuju ke rumah keluarga Park untuk wawancara. Setibanya di rumah Mr. Park pemilik perusahaan IT global, Ki-woo bertemu dengan Yeon-kyo, wanita muda yang cantik di rumah itu. Setelah pertemuan itu, serangkaian kejadian dimulai.",
                "Drama, Film Komedi, Misteri, Komedi Hitam, Cerita Seru",
                "2019",
                "9/10",
                "2 jam 12 menit",
                "https://assets.mubicdn.net/images/notebook/post_images/29836/images-w1400.jpg?1579571205"
            )
        )

        movies.add(
            MovieResponse(
                "a08",
                "Joker",
                "Arthur Fleck, seorang badut pesta, hidup dalam keadaan sulit bersama ibunya yang sakit-sakitan. Karena orang-orang menganggapnya aneh, ia memutuskan untuk berubah menjadi jahat dan membuat kekacauan.",
                "Drama, Cerita Seru, Kejahatan",
                "2019",
                "9/10",
                "2 jam 2 menit",
                "https://cdn.cgv.id/uploads/movie/pictures/19029600.jpg"
            )
        )

        movies.add(
            MovieResponse(
                "a09",
                "Your Name",
                "Alur. Mitsuha Miyamizu, seorang siswi sekolah menengah atas yang tinggal di desa fiktif bernama Itomori di daerah pegunungan Hida Prefektur Gifu, mulai bosan dengan kehidupannya di pedesaan tempat dia lahir dan berharap dapat terlahir menjadi pemuda tampan yang hidup di Tokyo pada kehidupan selanjutnya.",
                "Anime, Roman, Drama, Animasi, Film Fantasi",
                "2016",
                "9/10",
                "1 jam 52 menit",
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSdCn7P_niNCbNFHt9vLgDc-YlRIhwvnCPtHzyiHVP_GK-XmDS1"
            )
        )

        movies.add(
            MovieResponse(
                "a10",
                "Pokemon: Detective Pikachu",
                "Kisah ini bermula ketika detektif swasta ulung Harry Goodman menghilang secara tiba-tiba, mendorong putranya yang berumur 21 tahun untuk mencari tahu apa yang terjadi. Yang membantu penyelidikan adalah mantan mitra Pokmon Harry, Detective Pikachu: detektif ulung yang kocak dan menggemaskan yang membingungkan bahkan bagi dirinya sendiri. Mereka menemukan bahwa mereka saling melengkapi secara unik untuk berkomunikasi satu sama lain, Tim dan Pikachu bergabung dalam sebuah petualangan mendebarkan untuk mengungkap misteri yang kusut. Mengejar petunjuk bersama menyusuri jalan- jalan di Ryme City yang terang benderangsebuah kota metropolitan modern yang luas di mana manusia dan Pokmon hidup berdampingan dalam sebuah dunia hiper-realistismereka menghadapi beragam karakter Pokmon dan mengungkap plot mengejutkan yang bisa menghancurkan ko-eksistensi yang damai dan mengancam seluruh alam semesta Pokmon.",
                "Film anak-anak, Petualangan, Laga, Misteri, Animasi, Fiksi Ilmiah, Film Fantasi",
                "2019",
                "9/10",
                "1 jam 45 menit",
                "https://images-na.ssl-images-amazon.com/images/I/51MfhHo5CYL.jpg"
            )
        )

        return movies
    }

    fun generateDummyTvShows(): List<TvEntity> {

        val tvShows = ArrayList<TvEntity>()

        tvShows.add(
            TvEntity(
                "b01",
                "Chappelle's Show",
                "Chappelle's Show adalah serial televisi komedi sketsa Amerika yang dibuat oleh komedian Dave Chappelle dan Neal Brennan, dengan Chappelle menjadi pembawa acara dan membintangi sebagian besar sketsa. Chappelle, Brennan, dan Michele Armor adalah produser eksekutif acara tersebut.",
                "Komedi Sketsa, Film Komedi, Satire, Acara Ragam",
                "2003",
                "9/10",
                "28",
                false,
                "https://m.media-amazon.com/images/M/MV5BOWNjYTg5NGMtOWRjNy00ZGNlLTg2MmYtZjQ5NTM0MTQxOGM2XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_.jpg"
            )
        )

        tvShows.add(
            TvEntity(
                "b02",
                "The Sinner",
                "The Sinner merupakan seri televisi antalogi bergenre drama misteri kriminal asal Amerika Serikat. Delapan episode dari film ini berdasarkan novel dengan judul yang sama karya penulis kriminal Jerman Petra Hammesfahr dan pada awalnya dianggap sebagai \"seri tertutup\", pada Januari 2017 mulai diproduksi dan tayang perdana di USA Network pada 2 Agustus 2017. ",
                "Cerita Seru, Misteri, Drama, Dokumenter, Kejahatan",
                "2017",
                "9/10",
                "24",
                false,
                "https://images-na.ssl-images-amazon.com/images/I/81UMMWg6XFL.jpg"
            )
        )

        tvShows.add(
            TvEntity(
                "b03",
                "Marvel's Jessica Jones",
                "Marvel's Jessica Jones, atau Jessica Jones adalah serial televisi internet Amerika Serikat yang dibuat untuk Netflix oleh Melissa Rosenberg, berdasarkan karakter Marvel Comics dengan nama yang sama.",
                "Fiksi pahlawan super, Drama, Cerita seru psikologis, Fiksi kriminal",
                "2015",
                "8/10",
                "39",
                false,
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRHXCh-I1OGyrvg1iBeKnRXS4Vvlg4b24I0KgN3rq7POREqF3k7"
            )
        )

        tvShows.add(
            TvEntity(
                "b04",
                "The Get Down",
                "The Get Down adalah serial televisi drama musikal Amerika yang dibuat oleh Baz Luhrmann dan Stephen Adly Guirgis. Ini debut di Netflix pada 12 Agustus 2016, dan dibatalkan setelah musim pertama.",
                "Drama, Drama periode sejarah, Film musikal",
                "2016",
                "9/10",
                "11",
                false,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSq5XC9Fvp5Iw6XeAPf0oQNf2_qCYXdEckO_xEJGR_hLjEnEtKw"
            )
        )

        tvShows.add(
            TvEntity(
                "b05",
                "Big Mouth",
                "Big Mouth adalah komedi situasi animasi dewasa Amerika yang dibuat oleh penulis Family Guy Andrew Goldberg dan penulis skenario-sutradara Nick Kroll, Mark Levin, dan Jennifer Flackett",
                "Animasi dewasa, Film Komedi, Komedi Hitam",
                "2017",
                "9/10",
                "41",
                false,
                "https://resizing.flixster.com/Ut1VzHFB4Icq_9OMRw15k29LjZE=/fit-in/1152x864/v1.dDs2MjI3MDk7ajsxODcwOTsxMjAwOzI5NjY7NDQ0OQ"
            )
        )

        tvShows.add(
            TvEntity(
                "b06",
                "The Good Place",
                "The Good Place adalah serial televisi komedi fantasi Amerika Serikat yang diciptakan oleh Michael Schur. Serial tayang perdana pada 19 September 2016, di NBC.",
                "Komedi televisi, Fiksi filosofis, Televisi fantasi, Komedi situasi",
                "2016",
                "8/10",
                "28",
                false,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCxQBsAZh-Lyl5HY7VP9oL9A-W4z_Fx3u6zoY54NZi7IAO9nai"
            )
        )

        tvShows.add(
            TvEntity(
                "b07",
                "Black Mirror",
                "Black Mirror adalah seri antologi televisi Britania Raya besutan Charlie Brooker yang menceritakan kisah fiksi spekulatif dengan tema gelap dan satir mengenai masyarakat modern, terutama dampak buruk teknologi canggih. Seri ini diproduksi oleh Zeppotron untuk Endemol.",
                "Distopia, Fiksi Ilmiah, Satire, Drama, Komedi Hitam",
                "2011",
                "9/10",
                "22",
                false,
                "https://m.media-amazon.com/images/M/MV5BYTM3YWVhMDMtNjczMy00NGEyLWJhZDctYjNhMTRkNDE0ZTI1XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg"
            )
        )

        tvShows.add(
            TvEntity(
                "b08",
                "Orange is the New Black",
                "Orange Is the New Black adalah sebuah seri televisi web komedi-drama Amerika Serikat yang dibuat oleh Jenji Kohan untuk Netflix. Seri tersebut berdasarkan pada memoir Piper Kerman, Orange Is the New Black: My Year in a Women's Prison",
                "Perbuatan pidana, Komedi, Drama, Komedi Televisi",
                "2013",
                "8/10",
                "91",
                false,
                "https://cdn.flickeringmyth.com/wp-content/uploads/2018/07/OITNB-s6-poster-600x889.jpg"
            )
        )

        tvShows.add(
            TvEntity(
                "b09",
                "Unbreakable Kimmy Schmidt",
                "Kimmy Schmidt yang tidak bisa dipecahkan adalah sitkom televisi streaming Amerika yang dibuat oleh Tina Fey dan Robert Carlock, dibintangi oleh Ellie Kemper dalam peran utama. Ini ditayangkan perdana pada 6 Maret 2015, di Netflix dan berlangsung selama empat musim, berakhir pada 25 Januari 2019.",
                "Film Komedi, Komedi Situasi",
                "2015",
                "7/10",
                "52",
                false,
                "https://m.media-amazon.com/images/M/MV5BMTgyNTQyNjUwN15BMl5BanBnXkFtZTgwNjMwNjUzNzM@._V1_.jpg"
            )
        )

        tvShows.add(
            TvEntity(
                "b10",
                "Marvel’s Daredevil",
                "Marvel's Daredevil, atau Daredevil adalah seri Netflix yang dibuat oleh Drew Goddard berdasarkan Karakter Marvel Comics dengan nama yang sama. Seri ini berada dalam Marvel Cinematic Universe, dan menjadi seri pertama yang membangun miniseri The Defenders.",
                "Fiksi Pahlawan Super, Fiksi Kriminal, Fiksi Laga, Crime TV Genre, Fiksi Ilmiah",
                "2015",
                "9/10",
                "39",
                false,
                "https://m.media-amazon.com/images/M/MV5BODcwOTg2MDE3NF5BMl5BanBnXkFtZTgwNTUyNTY1NjM@._V1_.jpg"
            )
        )

        return tvShows
    }

    fun generateRemoteDummyTvShows(): List<TvResponse> {

        val tvShows = ArrayList<TvResponse>()

        tvShows.add(
            TvResponse(
                "b01",
                "Chappelle's Show",
                "Chappelle's Show adalah serial televisi komedi sketsa Amerika yang dibuat oleh komedian Dave Chappelle dan Neal Brennan, dengan Chappelle menjadi pembawa acara dan membintangi sebagian besar sketsa. Chappelle, Brennan, dan Michele Armor adalah produser eksekutif acara tersebut.",
                "Komedi Sketsa, Film Komedi, Satire, Acara Ragam",
                "2003",
                "9/10",
                "28",
                "https://m.media-amazon.com/images/M/MV5BOWNjYTg5NGMtOWRjNy00ZGNlLTg2MmYtZjQ5NTM0MTQxOGM2XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_.jpg"
            )
        )

        tvShows.add(
            TvResponse(
                "b02",
                "The Sinner",
                "The Sinner merupakan seri televisi antalogi bergenre drama misteri kriminal asal Amerika Serikat. Delapan episode dari film ini berdasarkan novel dengan judul yang sama karya penulis kriminal Jerman Petra Hammesfahr dan pada awalnya dianggap sebagai \"seri tertutup\", pada Januari 2017 mulai diproduksi dan tayang perdana di USA Network pada 2 Agustus 2017. ",
                "Cerita Seru, Misteri, Drama, Dokumenter, Kejahatan",
                "2017",
                "9/10",
                "24",
                "https://images-na.ssl-images-amazon.com/images/I/81UMMWg6XFL.jpg"
            )
        )

        tvShows.add(
            TvResponse(
                "b03",
                "Marvel's Jessica Jones",
                "Marvel's Jessica Jones, atau Jessica Jones adalah serial televisi internet Amerika Serikat yang dibuat untuk Netflix oleh Melissa Rosenberg, berdasarkan karakter Marvel Comics dengan nama yang sama.",
                "Fiksi pahlawan super, Drama, Cerita seru psikologis, Fiksi kriminal",
                "2015",
                "8/10",
                "39",
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRHXCh-I1OGyrvg1iBeKnRXS4Vvlg4b24I0KgN3rq7POREqF3k7"
            )
        )

        tvShows.add(
            TvResponse(
                "b04",
                "The Get Down",
                "The Get Down adalah serial televisi drama musikal Amerika yang dibuat oleh Baz Luhrmann dan Stephen Adly Guirgis. Ini debut di Netflix pada 12 Agustus 2016, dan dibatalkan setelah musim pertama.",
                "Drama, Drama periode sejarah, Film musikal",
                "2016",
                "9/10",
                "11",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSq5XC9Fvp5Iw6XeAPf0oQNf2_qCYXdEckO_xEJGR_hLjEnEtKw"
            )
        )

        tvShows.add(
            TvResponse(
                "b05",
                "Big Mouth",
                "Big Mouth adalah komedi situasi animasi dewasa Amerika yang dibuat oleh penulis Family Guy Andrew Goldberg dan penulis skenario-sutradara Nick Kroll, Mark Levin, dan Jennifer Flackett",
                "Animasi dewasa, Film Komedi, Komedi Hitam",
                "2017",
                "9/10",
                "41",
                "https://resizing.flixster.com/Ut1VzHFB4Icq_9OMRw15k29LjZE=/fit-in/1152x864/v1.dDs2MjI3MDk7ajsxODcwOTsxMjAwOzI5NjY7NDQ0OQ"
            )
        )

        tvShows.add(
            TvResponse(
                "b06",
                "The Good Place",
                "The Good Place adalah serial televisi komedi fantasi Amerika Serikat yang diciptakan oleh Michael Schur. Serial tayang perdana pada 19 September 2016, di NBC.",
                "Komedi televisi, Fiksi filosofis, Televisi fantasi, Komedi situasi",
                "2016",
                "8/10",
                "28",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCxQBsAZh-Lyl5HY7VP9oL9A-W4z_Fx3u6zoY54NZi7IAO9nai"
            )
        )

        tvShows.add(
            TvResponse(
                "b07",
                "Black Mirror",
                "Black Mirror adalah seri antologi televisi Britania Raya besutan Charlie Brooker yang menceritakan kisah fiksi spekulatif dengan tema gelap dan satir mengenai masyarakat modern, terutama dampak buruk teknologi canggih. Seri ini diproduksi oleh Zeppotron untuk Endemol.",
                "Distopia, Fiksi Ilmiah, Satire, Drama, Komedi Hitam",
                "2011",
                "9/10",
                "22",
                "https://m.media-amazon.com/images/M/MV5BYTM3YWVhMDMtNjczMy00NGEyLWJhZDctYjNhMTRkNDE0ZTI1XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg"
            )
        )

        tvShows.add(
            TvResponse(
                "b08",
                "Orange is the New Black",
                "Orange Is the New Black adalah sebuah seri televisi web komedi-drama Amerika Serikat yang dibuat oleh Jenji Kohan untuk Netflix. Seri tersebut berdasarkan pada memoir Piper Kerman, Orange Is the New Black: My Year in a Women's Prison",
                "Perbuatan pidana, Komedi, Drama, Komedi Televisi",
                "2013",
                "8/10",
                "91",
                "https://cdn.flickeringmyth.com/wp-content/uploads/2018/07/OITNB-s6-poster-600x889.jpg"
            )
        )

        tvShows.add(
            TvResponse(
                "b09",
                "Unbreakable Kimmy Schmidt",
                "Kimmy Schmidt yang tidak bisa dipecahkan adalah sitkom televisi streaming Amerika yang dibuat oleh Tina Fey dan Robert Carlock, dibintangi oleh Ellie Kemper dalam peran utama. Ini ditayangkan perdana pada 6 Maret 2015, di Netflix dan berlangsung selama empat musim, berakhir pada 25 Januari 2019.",
                "Film Komedi, Komedi Situasi",
                "2015",
                "7/10",
                "52",
                "https://m.media-amazon.com/images/M/MV5BMTgyNTQyNjUwN15BMl5BanBnXkFtZTgwNjMwNjUzNzM@._V1_.jpg"
            )
        )

        tvShows.add(
            TvResponse(
                "b10",
                "Marvel’s Daredevil",
                "Marvel's Daredevil, atau Daredevil adalah seri Netflix yang dibuat oleh Drew Goddard berdasarkan Karakter Marvel Comics dengan nama yang sama. Seri ini berada dalam Marvel Cinematic Universe, dan menjadi seri pertama yang membangun miniseri The Defenders.",
                "Fiksi Pahlawan Super, Fiksi Kriminal, Fiksi Laga, Crime TV Genre, Fiksi Ilmiah",
                "2015",
                "9/10",
                "39",
                "https://m.media-amazon.com/images/M/MV5BODcwOTg2MDE3NF5BMl5BanBnXkFtZTgwNTUyNTY1NjM@._V1_.jpg"
            )
        )

        return tvShows
    }

    fun generateDummyMovieWithId(movie: MovieEntity, favorited: Boolean): MovieWithId {
        movie.favorite = favorited
        return MovieWithId(movie, generateDummyMovies())
    }

    fun generateDummyTvShowWithId(tvShow: TvEntity, favorited: Boolean): TvWithId {
        tvShow.favorite = favorited
        return TvWithId(tvShow, generateDummyTvShows())
    }

}