<template>
<div>
  <el-table
     :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
    ref="multipleTable"
    tooltip-effect="dark"
    style="width: 100%"
    @selection-change="handleSelectionChange">
    <el-table-column type="selection" width="55"> </el-table-column>

    <el-table-column prop="performerName" label="Name" width="180"> </el-table-column>
    <el-table-column label="Pic" width="200">
        <template slot-scope="scope">
          <div class="demo-image__preview">
          <el-image
          style="width: 100px; height: 100px"
          :src="url"
          :preview-src-list="srcList">
        </el-image>
      </div>
      <el-upload
        class="upload-demo"
        action="https://jsonplaceholder.typicode.com/posts/"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :before-remove="beforeRemove"
        multiple
        :limit="3"
        :on-exceed="handleExceed"
        :file-list="fileList">
      <el-tooltip placement="bottom" effect="light">
        <div slot="content">Only jpg/png files can be uploaded, <br/> and no more than 500kb</div>
        <el-button
              size="mini"
              type="warning"
              plain
              @click="handleUpdatePic(scope.$index, scope.row)">update</el-button>
      </el-tooltip>
      </el-upload>
        </template>
    </el-table-column>
    <el-table-column prop="performerIntroduction" label="Introduction" width="400" ></el-table-column>
    <el-table-column
      prop="performerType"
      label="perfomerType"
      :filters="[{ text: 'violinist', value: 'violinsit' }, { text: 'pianist', value: 'pianist' }]"
      :filter-method="filterTag"
      filter-placement="bottom-end">
      <template slot-scope="scope">
        <el-tag
          disable-transitions>{{scope.row.performerType}}</el-tag>
      </template>
    </el-table-column>
    <el-table-column   >
        <template slot="header">
        <el-input
          v-model="search"
          size="mini"
          placeholder="search..."/>
      </template>
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row);dialogVisible = true">Edit</el-button>
          <el-dialog
            title="Performer"
            :visible.sync="dialogVisible"
            width="60%"
            :before-close="handleClose">
            <el-form ref="form" :model="form" label-width="120px">
              <el-form-item label="Name">
                <el-input v-model="form.name"></el-input>
              </el-form-item>
              <el-form-item label="Introduction">
                <el-input type="textarea" v-model="form.desc"></el-input>
              </el-form-item>
              <el-form-item label="performer type">
                <el-select v-model="form.region" placeholder="pick a type...">
                  <el-option label="violinist" value="violinist"></el-option>
                  <el-option label="pianist" value="pianist"></el-option>
                </el-select>
              </el-form-item>

              <!-- <el-form-item>
                <el-button type="primary" @click="onSubmit">ok</el-button>
                <el-button>Cancel</el-button>
              </el-form-item> -->
            </el-form>
            <span slot="footer" class="dialog-footer">
              <el-button @click="dialogVisible = false">Cancel</el-button>
              <el-button type="primary" @click="dialogVisible = false">Confirm</el-button>
            </span>
          </el-dialog>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row);open()">Del</el-button>
      </template>
    </el-table-column>
  </el-table>

  </div>
</template>
<script>
export default {
  data () {
    return {
      value: [],
      filterMethod (query, item) {
        return item.pinyin.indexOf(query) > -1
      },
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      dialogVisible: false,
      tagVisible: false,
      tableData: [
        {
          performerName: 'Hilary Hahn',
          performerPic: 'Pic',
          performerIntroduction: 'Hilary Hahn (born November 27, 1979) is an American violinist. She has performed throughout the world as a soloist with leading orchestras and conductors and as a recitalist. She is an avid supporter of contemporary classical music, and several composers have written works for her, including concerti by Edgar Meyer and Jennifer Higdon, partitas by Antón García Abril, two serenades for violin and orchestra by Einojuhani Rautavaara, and a violin and piano sonata by Lera Auerbach.',
          performerType: 'violinist'
        },
        {
          performerName: 'Hilary Hahn',
          performerPic: 'Pic',
          performerIntroduction: 'Hilary Hahn (born November 27, 1979) is an American violinist. She has performed throughout the world as a soloist with leading orchestras and conductors and as a recitalist. She is an avid supporter of contemporary classical music, and several composers have written works for her, including concerti by Edgar Meyer and Jennifer Higdon, partitas by Antón García Abril, two serenades for violin and orchestra by Einojuhani Rautavaara, and a violin and piano sonata by Lera Auerbach.',
          performerType: 'violinist'
        },
        {
          performerName: 'Hilary Hahn',
          performerPic: 'Pic',
          performerIntroduction: 'Hilary Hahn (born November 27, 1979) is an American violinist. She has performed throughout the world as a soloist with leading orchestras and conductors and as a recitalist. She is an avid supporter of contemporary classical music, and several composers have written works for her, including concerti by Edgar Meyer and Jennifer Higdon, partitas by Antón García Abril, two serenades for violin and orchestra by Einojuhani Rautavaara, and a violin and piano sonata by Lera Auerbach.',
          performerType: 'violinist'
        },
        {
          performerName: 'Hilary Hahn',
          performerPic: 'Pic',
          performerIntroduction: 'Hilary Hahn (born November 27, 1979) is an American violinist. She has performed throughout the world as a soloist with leading orchestras and conductors and as a recitalist. She is an avid supporter of contemporary classical music, and several composers have written works for her, including concerti by Edgar Meyer and Jennifer Higdon, partitas by Antón García Abril, two serenades for violin and orchestra by Einojuhani Rautavaara, and a violin and piano sonata by Lera Auerbach.',
          performerType: 'violinist'
        },
        {
          performerName: 'Hilary Hahn',
          performerPic: 'Pic',
          performerIntroduction: 'Hilary Hahn (born November 27, 1979) is an American violinist. She has performed throughout the world as a soloist with leading orchestras and conductors and as a recitalist. She is an avid supporter of contemporary classical music, and several composers have written works for her, including concerti by Edgar Meyer and Jennifer Higdon, partitas by Antón García Abril, two serenades for violin and orchestra by Einojuhani Rautavaara, and a violin and piano sonata by Lera Auerbach.',
          performerType: 'violinist'
        }
      ],
      url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
      srcList: [
        'https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg',
        'https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg'
      ],

      search: '',
      multipleSelection: []
    }
  },

  methods: {
    toggleSelection (rows) {
      if (rows) {
        rows.forEach((row) => {
          this.$refs.multipleTable.toggleRowSelection(row)
        })
      } else {
        this.$refs.multipleTable.clearSelection()
      }
    },
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    filterTag (value, row) {
      return row.user_status === value
    },
    handleUpdatePic (index, row) {
      console.log(index, row)
    },
    handleEdit (index, row) {
      console.log(index, row)
    },
    handleClose (done) {
      this.$confirm('Are you sure to close it?')
        .then(_ => {
          done()
        })
        .catch(_ => {})
    },
    handleDelete (index, row) {
      console.log(index, row)
    },
    handleTags (index, row) {
      console.log(index, row)
    },
    open () {
      this.$confirm('Are you sure to delete it?', 'Tip', {
        confirmButtonText: 'yes',
        cancelButtonText: 'no',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'success',
          message: 'Deleted successfully!'
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: 'Deletions have been reversed'
        })
      })
    }
  }
}
</script>
<style scope>

</style>
