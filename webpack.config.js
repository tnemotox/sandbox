var path = require('path')
var webpack = require('webpack')

module.exports = {
  entry: {
    'props-chain': './src/main/webapp/vue/props-chain/main.js',
    xss: './src/main/webapp/vue/xss/main.js',
  },
  output: {
    path: path.resolve(__dirname, 'src', 'main', 'resources', 'static', 'build'),
    publicPath: '/build/',
    filename: '[name].build.js'
  },
  module: {
    rules: [
      {
        test: /\.css$/,
        use: [
          'vue-style-loader',
          'css-loader'
        ],
      },      {
        test: /\.vue$/,
        loader: 'vue-loader',
        options: {
          loaders: {
          }
          // other vue-loader options go here
        }
      },
      {
        test: /\.js$/,
        loader: 'babel-loader',
        exclude: /node_modules/
      },
      {
        test: /\.(png|jpg|gif|svg)$/,
        loader: 'file-loader',
        options: {
          name: '[name].[ext]?[hash]'
        }
      }
    ]
  },
  resolve: {
    alias: {
      'vue$': 'vue/dist/vue.esm.js'
    },
    extensions: ['*', '.js', '.vue', '.json']
  },
  devServer: {
    watchContentBase: true,
    hot: true,
    inline: true,
    historyApiFallback: true,
    noInfo: false,
    overlay: true,
    open: true,
    contentBase: path.join(__dirname, 'src/main/resources'),
    openPage: 'templates/vue-xss.html'
  },
  performance: {
    hints: false
  },
  devtool: '#eval-source-map'
}
