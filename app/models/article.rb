class Article < ActiveRecord::Base
	# la tabla Article => articles 
	# campos => article.title() => "El titulo del articulo"
	validates :title, presence: true
	validates :body, presence: true, length: {minimum: 20}

end
