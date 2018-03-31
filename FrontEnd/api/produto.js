const restful = require('node-restful')

const mongoose = restful.mongoose

const lojaSchema = new mongoose.Schema(
    {

      sku: {type: Number, min: 0, require: true},
      title: {type: String},
      description: {type: String, require: true},
      availableSize:  {type: String, require: false, uppercase: true,
        enum: ["S", "G", "GG", "GGG"]},
      style: {type: String},
      price: {type: Number},
      installments: {type: Number},
      currencyId: {type: String},
      currencyForma: {type: String},
      isFreeShipping: {type: Boolean}
    })

module.exports = restful.model('LojaModel', lojaSchema)