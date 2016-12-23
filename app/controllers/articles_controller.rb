class ArticlesController < ApplicationController
	# GET Articles
	def index
		# Busca todos los registros
		@articles = Article.all 
	end
	#GET Articles/id:
	def show
		# Busca un registro por su id
		@articles = Article.find(params[:id])
		# Where
		Article.where(" id = ? AND title = ? ", params[:id], params[:title])
	end
	#GET Articles/new
	def new
		@articles = Article.new 
	end
	#POST /Articles
	def create
		@articles = Article.new(article_params)

		if @articles.save
			redirect_to @articles
		else
			render :new
		end
	end

	def update
		# Para hacer updates
	end

	def destroy
		@articles = Article.find(params[:id])
		@articles.destroy # Elimina el objeto de la BD
		redirect_to articles_path
	end

	private # Todo lo que este debajo de Private solo lo podra usar la clase

	def article_params
		params.require(:article).permit(:title, :body)
end