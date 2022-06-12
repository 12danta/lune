<template>
<div>
  <el-table
     :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
    ref="multipleTable"
    tooltip-effect="dark"
    style="width: 100%"
    @selection-change="handleSelectionChange">
    <el-table-column type="selection" width="55"> </el-table-column>

    <el-table-column prop="composerName" label="Name" width="180"> </el-table-column>
    <el-table-column label="Pic" width="180">
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
    <el-table-column prop="composerIntroduction" label="Introduction" width="300" ></el-table-column>
    <el-table-column prop="composerLifeAndDeath" label="life and death" width="150" ></el-table-column>
    <el-table-column
      prop="composerPeriod"
      label="Period"
      :filters="[{ text: 'violinist', value: 'violinsit' }, { text: 'pianist', value: 'pianist' }]"
      :filter-method="filterTag"
      filter-placement="bottom-end">
      <template slot-scope="scope">
        <el-tag
          disable-transitions>{{scope.row.composerPeriod}}</el-tag>
      </template>
    </el-table-column>
    <el-table-column>
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
            title="Composer"
            :visible.sync="dialogVisible"
            width="60%"
            :before-close="handleClose">
            <el-form ref="form" :model="form" label-width="100px">
              <el-form-item label="Name">
                <el-input v-model="form.name"></el-input>
              </el-form-item>
              <el-form-item label="Introduction">
                <el-input type="textarea" v-model="form.desc"></el-input>
              </el-form-item>
              <el-form-item label="Life and Death" label-width="120px">
                <template>
                  <div class="block">
                    <!-- <span class="demonstration">带快捷选项</span> -->
                    <el-date-picker
                      v-model="value2"
                      type="daterange"
                      align="right"
                      unlink-panels
                      range-separator="至"
                      start-placeholder="开始日期"
                      end-placeholder="结束日期"
                      :picker-options="pickerOptions">
                    </el-date-picker>
                  </div>
                </template>
              </el-form-item>
              <!-- <el-form-item>
                <el-button type="primary" @click="onSubmit">ok</el-button>
                <el-button>Cancel</el-button>
              </el-form-item> -->
            <el-form-item label="Pieriod">
                <el-select v-model="form.region" placeholder="pick the Pieriod">
                  <el-option label="Romantic period" value="Romantic period"></el-option>
                  <el-option label="Classical period" value="Classical period"></el-option>
                </el-select>
              </el-form-item>
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
  <div style="margin-top: 20px">
    <el-button @click="toggleSelection([tableData[1], tableData[2]])">切换第二、第三行的选中状态</el-button>
    <el-button @click="toggleSelection()">Cancel select</el-button>
  </div>
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
          composerName: 'Pyotr Ilyich Tchaikovsky',
          composerPic: 'Pic',
          composerIntroduction: 'Pyotr Ilyich Tchaikovsky（Russian: Пётр Ильи́ч Чайко́вский7 May 1840 – 6 November 1893 ）was a Russian composer of the Romantic period .He was the first Russian composer whose music would make a lasting impression internationally. He wrote some of the most popular concert and theatrical music in the current classical repertoire, including the ballets Swan Lake and The Nutcracke, the 1812 Overture, his First Piano Concerto, Violin Concerto several symphonies, and the opera Eugene Onegin.',
          composerLifeAndDeath: '7 May 1840 – 6 November 1893',
          composerPeriod: 'Romantic period'
        },
        {
          composerName: 'Pyotr Ilyich Tchaikovsky',
          composerPic: 'Pic',
          composerIntroduction: 'Pyotr Ilyich Tchaikovsky（Russian: Пётр Ильи́ч Чайко́вский7 May 1840 – 6 November 1893 ）was a Russian composer of the Romantic period .He was the first Russian composer whose music would make a lasting impression internationally. He wrote some of the most popular concert and theatrical music in the current classical repertoire, including the ballets Swan Lake and The Nutcracke, the 1812 Overture, his First Piano Concerto, Violin Concerto several symphonies, and the opera Eugene Onegin.',
          composerLifeAndDeath: '7 May 1840 – 6 November 1893',
          composerPeriod: 'Romantic period'
        },
        {
          composerName: 'Pyotr Ilyich Tchaikovsky',
          composerPic: 'Pic',
          composerIntroduction: 'Pyotr Ilyich Tchaikovsky（Russian: Пётр Ильи́ч Чайко́вский7 May 1840 – 6 November 1893 ）was a Russian composer of the Romantic period .He was the first Russian composer whose music would make a lasting impression internationally. He wrote some of the most popular concert and theatrical music in the current classical repertoire, including the ballets Swan Lake and The Nutcracke, the 1812 Overture, his First Piano Concerto, Violin Concerto several symphonies, and the opera Eugene Onegin.',
          composerLifeAndDeath: '7 May 1840 – 6 November 1893',
          composerPeriod: 'Romantic period'
        },
        {
          composerName: 'Pyotr Ilyich Tchaikovsky',
          composerPic: 'Pic',
          composerIntroduction: 'Pyotr Ilyich Tchaikovsky（Russian: Пётр Ильи́ч Чайко́вский7 May 1840 – 6 November 1893 ）was a Russian composer of the Romantic period .He was the first Russian composer whose music would make a lasting impression internationally. He wrote some of the most popular concert and theatrical music in the current classical repertoire, including the ballets Swan Lake and The Nutcracke, the 1812 Overture, his First Piano Concerto, Violin Concerto several symphonies, and the opera Eugene Onegin.',
          composerLifeAndDeath: '7 May 1840 – 6 November 1893',
          composerPeriod: 'Romantic period'
        },
        {
          composerName: 'Pyotr Ilyich Tchaikovsky',
          composerPic: 'Pic',
          composerIntroduction: 'Pyotr Ilyich Tchaikovsky（Russian: Пётр Ильи́ч Чайко́вский7 May 1840 – 6 November 1893 ）was a Russian composer of the Romantic period .He was the first Russian composer whose music would make a lasting impression internationally. He wrote some of the most popular concert and theatrical music in the current classical repertoire, including the ballets Swan Lake and The Nutcracke, the 1812 Overture, his First Piano Concerto, Violin Concerto several symphonies, and the opera Eugene Onegin.',
          composerLifeAndDeath: '7 May 1840 – 6 November 1893',
          composerPeriod: 'Romantic period'
        },
        {
          composerName: 'Pyotr Ilyich Tchaikovsky',
          composerPic: 'Pic',
          composerIntroduction: 'Pyotr Ilyich Tchaikovsky（Russian: Пётр Ильи́ч Чайко́вский7 May 1840 – 6 November 1893 ）was a Russian composer of the Romantic period .He was the first Russian composer whose music would make a lasting impression internationally. He wrote some of the most popular concert and theatrical music in the current classical repertoire, including the ballets Swan Lake and The Nutcracke, the 1812 Overture, his First Piano Concerto, Violin Concerto several symphonies, and the opera Eugene Onegin.',
          composerLifeAndDeath: '7 May 1840 – 6 November 1893',
          composerPeriod: 'Romantic period'
        }
      ],
      url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
      srcList: [
        'https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg',
        'https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg'
      ],
      search: '',
      multipleSelection: [],
      pickerOptions: {
        shortcuts: [{
          text: '最近一周',
          onClick (picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近一个月',
          onClick (picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近三个月',
          onClick (picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
            picker.$emit('pick', [start, end])
          }
        }]
      },
      value1: '',
      value2: ''
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
      this.$confirm('Are you sure to close it ?')
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
